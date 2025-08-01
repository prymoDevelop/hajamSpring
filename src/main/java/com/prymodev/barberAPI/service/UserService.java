package com.prymodev.barberAPI.service;


import com.prymodev.barberAPI.domain.DTO.UserDTO;
import com.prymodev.barberAPI.domain.entity.AppRole;
import com.prymodev.barberAPI.domain.entity.AppUser;
import java.util.*;

public interface UserService {

    AppUser saveUser(UserDTO userDTO);

    void addRoleToUser(String username, String role);

    AppUser loadUserByEmail(String username);

    List<AppUser> getAllUsers();
    AppUser getUser(Long id);


    AppRole saveRole(AppRole role);

}
