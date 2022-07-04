package com.prymodev.DTO;

import com.prymodev.entity.AppRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends AbstractDTO{

    private String username;
    private String email;
    private String password;
    private String passwordRepeated;
    private int phoneNumber;
    private boolean active;
    private AppRole roles;


}
