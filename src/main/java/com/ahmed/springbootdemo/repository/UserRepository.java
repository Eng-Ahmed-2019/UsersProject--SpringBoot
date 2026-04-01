package com.ahmed.springbootdemo.repository;

import com.ahmed.springbootdemo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}