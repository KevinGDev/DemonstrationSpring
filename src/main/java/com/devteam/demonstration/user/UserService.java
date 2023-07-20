package com.devteam.demonstration.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<String> userList = new ArrayList<>();


    public String getUserByName(String name) {
        // Ici on simule une table user avec 4 utilisateurs
        userList.add("Fatou");
        userList.add("Ronan");
        userList.add("Camille");
        userList.add("Zineb");

        // Ce paramètre sera retourné
        String foundUser = "";

        for (String user : userList
        ) {
            if (user.equals(name)) {
                foundUser = user;
            }
        }

        return foundUser;
    }
}
