package com.ahmed.springbootdemo.service;

import java.util.*;
import com.ahmed.springbootdemo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public List<User> GetAllUsers() {
        return users;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> DeleteUser(User user) {
        users.remove(user);
        return users;
    }
}