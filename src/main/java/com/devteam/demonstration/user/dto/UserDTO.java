package com.devteam.demonstration.user.dto;

import com.devteam.demonstration.user.dao.UserDAO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String role;


    public UserDTO(UserDAO userDAO) {
        this.name = userDAO.getName();
        this.email = userDAO.getEmail();
        this.role = userDAO.getRole();
    }
}