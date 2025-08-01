package com.prymodev.barberAPI.controller;

import com.prymodev.barberAPI.domain.DTO.UserDTO;
import com.prymodev.barberAPI.domain.entity.AppUser;
import com.prymodev.barberAPI.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/")
@Slf4j
@AllArgsConstructor
@RestController
public class UsersController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AppUser> signUp(@RequestBody UserDTO userDTO) {

        return ResponseEntity.ok().body(userService.saveUser(userDTO));
    }

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsersPage() {
        log.debug("Getting users page");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable Long id) {
        log.debug("Getting user");
        return ResponseEntity.ok(userService.getUser(id));
    }


}
