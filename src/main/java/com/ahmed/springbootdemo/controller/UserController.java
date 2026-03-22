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

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User UpDateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}