package com.devteam.demonstration.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    // Injection de dépendance avec @Autowired
    @Autowired
    UserService userService;

    // Injection de dépendance par constructeur
//    UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // Si l'on ne préciser pas de route après GetMapping c'est la route par défaut
    @GetMapping
    public String getUser() {
        log.info("USER CONTROLLER - RECUPERATION D'UN UTILISATEUR");
        return "Kevin";
    }


    @GetMapping("/getUser")
    public String getUserByName(@RequestParam String name) {
        log.info("USER CONTROLLER - RECUPERATION D'UN UTILISATEUR AYANT LE NOM " + name);
        return userService.getUserByName(name);

    }


}
