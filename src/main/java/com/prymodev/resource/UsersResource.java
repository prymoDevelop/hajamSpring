package com.prymodev.resource;

import com.prymodev.DTO.UserDTO;
import com.prymodev.entity.AppUser;
import com.prymodev.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/")
@Slf4j
@AllArgsConstructor
@RestController
@Api( tags = "Clients")
public class UsersResource {

    private final UserService userService;

    //
//
    @ApiOperation(value = "This method is used to register user.")
    @PostMapping("/signup")
    public ResponseEntity<AppUser> signUp(@RequestBody UserDTO userDTO) {

        return ResponseEntity.ok().body(userService.saveUser(userDTO));
    }

    //
    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsersPage() {
        log.debug("Getting users page");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable String id) {
        log.debug("Getting user");
        return ResponseEntity.ok(userService.getUser(id));
    }


}
