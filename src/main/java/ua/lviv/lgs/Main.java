package ua.lviv.lgs;

import ua.lviv.lgs.connection.ConnectionManager;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.UserServiseImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiseImpl();
//        User user = new User("test2@mail.com", "test2", "test2", "USER");

//        User savedUser = userService.save(user);
//        User savedUser = userService.findById(3);
//        System.out.println(savedUser);


        List<User> users = userService.findAll();
        System.out.println(users);
        ConnectionManager.closeConnection();

    }
}
