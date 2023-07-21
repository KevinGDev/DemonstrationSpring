package com.devteam.demonstration.user;

import com.devteam.demonstration.user.dao.UserDAO;
import com.devteam.demonstration.user.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<UserDAO> userList = new ArrayList<>();

    public UserDTO getUserByEmail(String name) {

        UserDTO foundUser = new UserDTO();

        for (UserDAO user : userList
        ) {
            if (user.getEmail().equals(name)) {
                foundUser = new UserDTO(user);

            }
        }
        return foundUser;
    }

    public UserDAO getUserByEmailDAO(String name) {
        // Ce paramètre sera retourné
        UserDAO foundUser = new UserDAO();

        for (UserDAO user : userList
        ) {
            if (user.getEmail().equals(name)) {
                foundUser = user;
            }
        }
        return foundUser;
    }


    public List<UserDAO> addUser(UserDAO user) {
        userList.add(user);
        return userList;
    }

    /**
     * Cette fonction va transformer tous les userDAO en userDTO et retourner une liste d'userDTO
     *
     * @return une liste d'userDTO
     */
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();

        // Il est possible de réaliser la transformation grâce à l'API Stream inclue à partir de Java 8
        userList.stream().forEach(userDAO -> userDTOList.add(new UserDTO(userDAO)));

        // Il est également possible de faire un forEach directement sur la collection
//        userList.forEach(userDAO -> {
//            userDTOList.add(new UserDTO(userDAO));
//        } );


//        // Ou encore une boucle for simple
//        for (int i = 0; i < userList.size(); i++){
//            userDTOList.add(new UserDTO(userList.get(i)));
//        }

//        // Ou un autre type de boucle for
//        for (UserDAO userDAO: userList
//             ) {
//            userDTOList.add(new UserDTO(userDAO));
//        }
        return userDTOList;
    }
}
