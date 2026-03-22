package com.ahmed.springbootdemo.repository;

import com.ahmed.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}