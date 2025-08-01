package com.prymodev.barberAPI.domain.DTO;

import com.prymodev.barberAPI.domain.entity.AppRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
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
