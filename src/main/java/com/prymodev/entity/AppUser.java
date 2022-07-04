package com.prymodev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;


@Data
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    private String id;
    private String username;
    @Indexed(unique = true)
    private String email;
    private String password;
    private int phoneNumber;
    private boolean actived;
    private Collection<AppRole> roles = new ArrayList<>();



}
