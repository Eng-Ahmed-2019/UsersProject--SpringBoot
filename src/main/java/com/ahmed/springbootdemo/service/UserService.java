package com.ahmed.springbootdemo.service;

import java.util.*;
import com.ahmed.springbootdemo.model.User;
import org.springframework.stereotype.Service;
import com.ahmed.springbootdemo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        User u = userRepository.findById(id).orElse(null);
        return u;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = getUser(id);
        if (existing == null) return null;

        existing.setName(user.getName());
        existing.setAge(user.getAge());

        return userRepository.save(existing);
    }

    public List<User> deleteUser(long id) {
        User u = getUser(id);
        if (u == null) return null;
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
}