package com.prymodev.barberAPI.service.impl;

import com.prymodev.barberAPI.domain.DTO.UserDTO;
import com.prymodev.barberAPI.domain.entity.AppRole;
import com.prymodev.barberAPI.domain.entity.AppUser;
import com.prymodev.barberAPI.exception.ApiRequestException;
import com.prymodev.barberAPI.domain.repository.RoleRepository;
import com.prymodev.barberAPI.domain.repository.UserRepository;
import com.prymodev.barberAPI.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Bean
    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public AppUser loadUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> getAllUsers() {
        log.debug("Getting all users");
        return userRepository.findAll(Sort.by("email"));
    }

    @Override
    public AppUser getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ApiRequestException("Ooopsss No user with that id"));
    }

    @Override
    public AppUser saveUser(UserDTO userDTO) {
        String email = userDTO.getEmail();
        AppUser user = userRepository.findByEmail(email);
        if (user != null) {
            throw new RuntimeException("This is already exists, Try with an other email");
        }
        String password = userDTO.getPassword();
        String repassword = userDTO.getPasswordRepeated();
        if (!password.equals(repassword)) {
            throw new RuntimeException("You must confirm your password");
        }
        AppUser appUser = new AppUser();
        appUser.setUsername(userDTO.getUsername());
        appUser.setEmail(userDTO.getEmail());
        appUser.setActive(true);
        appUser.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userRepository.save(appUser);
        addRoleToUser(email, userDTO.getRoles().getRoleName());
        return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        AppUser user = userRepository.findByEmail(email);

        AppRole role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);

    }
}
