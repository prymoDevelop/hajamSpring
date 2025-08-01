package com.prymodev.barberAPI.init;

import com.prymodev.barberAPI.domain.DTO.UserDTO;
import com.prymodev.barberAPI.domain.entity.AppRole;
import com.prymodev.barberAPI.domain.entity.AppUser;
import com.prymodev.barberAPI.domain.repository.RoleRepository;
import com.prymodev.barberAPI.domain.repository.UserRepository;
import com.prymodev.barberAPI.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @PostConstruct
    public void init() {
        if (roleRepository.count() == 0) {
            roleRepository.save(new AppRole(null, "USER"));
            AppRole adminRole = roleRepository.save(new AppRole(null, "ADMIN"));
            AppUser user = userRepository.findByEmail("admin@gmail.com");

            if (user == null) {
                userService.saveUser(new UserDTO(
                                "admin",
                                "admin@gmail.com",
                                "admin123",
                                "admin123",
                                26834400,
                                true,
                                adminRole
                        )
                );
            }
        }
    }
}
