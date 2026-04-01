package com.ahmed.springbootdemo.controller;

import java.util.*;
import jakarta.validation.Valid;
import com.ahmed.springbootdemo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.ahmed.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService _userService;

    public UserController(UserService userService) {
        this._userService = userService;
    }

    @GetMapping
    public Page<User> getUsers(Pageable pageable) {
        return _userService.getAllUsers(pageable);
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return _userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public Page<User> deleteUser(@PathVariable Long id, Pageable pageable) {
        return _userService.deleteUser(id, pageable);
    }

    @GetMapping("/{id}")
    public User getUser(@RequestParam(required = false) String name, @PathVariable Long id, Pageable pageable) {
        if (name != null) {
            _userService.searchByName(name, pageable);
        }
        return _userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User UpDateUser(@Valid @PathVariable Long id, @RequestBody User user) {
        return _userService.updateUser(id, user);
    }
}