package com.prymodev.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class AppRole {

    @Id
    private String id;
    private String roleName;

}
