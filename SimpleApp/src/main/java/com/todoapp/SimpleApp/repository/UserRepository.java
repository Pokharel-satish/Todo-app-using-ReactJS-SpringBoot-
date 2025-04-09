package com.todoapp.SimpleApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.SimpleApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Corrected parameter type from Object to String
    Optional<User> findByUsername(String username);
}
