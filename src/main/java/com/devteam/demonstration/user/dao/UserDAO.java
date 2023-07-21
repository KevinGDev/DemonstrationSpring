package com.devteam.demonstration.user.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDAO {
    private String name;
    private String age;
    private String email;
    private String address;
    private String role;
    private String entity;

}
