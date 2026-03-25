package com.ahmed.springbootdemo.service;

import java.util.*;
import com.ahmed.springbootdemo.model.User;
import org.springframework.stereotype.Service;
import com.ahmed.springbootdemo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return _userRepository.findAll(); // FindAll Built-in Function...
    }

    public User getUser(Long id) {
        User u = _userRepository.findById(id).orElse(null);
        return u;
    }

    public User addUser(User user) {
        return _userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = getUser(id);
        if (existing == null) return null;

        existing.setName(user.getName());
        existing.setAge(user.getAge());

        return _userRepository.save(existing);
    }

    public List<User> deleteUser(Long id) {
        User u = getUser(id);
        if (u == null) return null;
        _userRepository.deleteById(id);
        return _userRepository.findAll();
    }
}