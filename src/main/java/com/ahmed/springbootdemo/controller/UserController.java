package com.ahmed.springbootdemo.controller;

import java.util.*;
import com.ahmed.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;
import com.ahmed.springbootdemo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public List<User> GetAllUsers() {
        return userService.GetAllUsers();
    }

    @PostMapping("/createUser")
    public User CreateUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser")
    public List<User> DeleteUser(User user) {
        return userService.DeleteUser(user);
    }
}