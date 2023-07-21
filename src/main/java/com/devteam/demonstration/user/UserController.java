package com.devteam.demonstration.user;

import com.devteam.demonstration.user.dao.UserDAO;
import com.devteam.demonstration.user.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    // Injection de dépendance avec @Autowired
    @Autowired
    UserService userService;

    // Injection de dépendance par constructeur
        //    UserService userService;
        //
        //    public UserController(UserService userService) {
        //        this.userService = userService;
        //    }

    // Si l'on ne préciser pas de route après GetMapping c'est la route par défaut
    @GetMapping
    public List<UserDTO> getAllUsers() {
        log.info("USER CONTROLLER - RECUPERATION DE TOUS LES UTILISATEURS");
        return userService.getAllUsers();
    }


    @GetMapping("/getUser")
    public UserDTO getUserByEmail(@RequestParam String email) {
        log.info("USER CONTROLLER - RECUPERATION D'UN UTILISATEUR AYANT LE NOM " + email);
        return userService.getUserByEmail(email);
    }

    @GetMapping("/getUserDAO")
    public UserDAO getUserByEmailDAO(@RequestParam String email) {
        log.info("USER CONTROLLER - RECUPERATION D'UN UTILISATEUR AYANT LE NOM " + email);
        return userService.getUserByEmailDAO(email);
    }


    @PostMapping
    public List<UserDAO> addUser(@RequestBody UserDAO user){
        log.info("USER CONTROLLER - INSERTION D'UN UTILISATEUR AYANT LE NOM " + user.getName());
        return userService.addUser(user);
    }


}
