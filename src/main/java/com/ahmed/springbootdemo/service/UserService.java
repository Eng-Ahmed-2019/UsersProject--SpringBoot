package com.ahmed.springbootdemo.service;

import java.util.*;
import com.ahmed.springbootdemo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;
import com.ahmed.springbootdemo.repository.UserRepository;

@Service
@Component
public class UserService {
    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        this._userRepository = userRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return _userRepository.findAll(pageable); // FindAll Built-in Function...
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

    public Page<User> deleteUser(Long id, Pageable pageable) {
        User u = getUser(id);
        if (u == null) return null;
        _userRepository.deleteById(id);
        return _userRepository.findAll(pageable);
    }

    public Page<User> searchByName(String name, Pageable pageable) {
        return _userRepository.findByNameContainingIgnoreCase(name, pageable);
    }
}