package com.prymodev;

import com.prymodev.DTO.UserDTO;
import com.prymodev.entity.AppRole;
import com.prymodev.entity.AppUser;
import com.prymodev.repository.RoleRepository;
import com.prymodev.repository.UserRepository;
import com.prymodev.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
public class HajamBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(HajamBackApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService,
                            UserRepository userRepository,
                            RoleRepository roleRepository) {

        return args -> {
            roleRepository.deleteAll();
            userRepository.deleteAll();
            userService.saveRole(new AppRole(null, "USER"));
            AppRole role = userService.saveRole(new AppRole(null, "ADMIN"));
            AppUser user = userService.saveUser(new UserDTO(
                    "admin",
                    "admin@gmail.com",
                    "admin123",
                    "admin123",
                    26834400,
                    true,
                    role
            ));
        };
    }
}
