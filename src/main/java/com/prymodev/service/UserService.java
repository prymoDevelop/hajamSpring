package com.prymodev.service;


import com.prymodev.DTO.UserDTO;
import com.prymodev.entity.AppRole;
import com.prymodev.entity.AppUser;
import java.util.*;

public interface UserService {

    public AppUser saveUser(UserDTO userDTO);

    public void addRoleToUser(String username, String role);

    public AppUser loadUserByEmail(String username);

    public List<AppUser> getAllUsers();
    public AppUser getUser(String id);


    public AppRole saveRole(AppRole role);

}
