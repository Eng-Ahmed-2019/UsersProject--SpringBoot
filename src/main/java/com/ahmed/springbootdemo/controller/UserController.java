package com.ahmed.springbootdemo.controller;

import java.util.*;
import jakarta.validation.Valid;
import com.ahmed.springbootdemo.model.User;
import org.springframework.web.bind.annotation.*;
import com.ahmed.springbootdemo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService _userService;

    public UserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return _userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return _userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable Long id) {
        return _userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return _userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User UpDateUser(@Valid @PathVariable Long id, @RequestBody User user) {
        return _userService.updateUser(id, user);
    }
}