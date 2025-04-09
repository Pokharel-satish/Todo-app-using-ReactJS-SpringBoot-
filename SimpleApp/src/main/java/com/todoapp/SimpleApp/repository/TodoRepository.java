package com.todoapp.SimpleApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.SimpleApp.entity.Todo;
import com.todoapp.SimpleApp.entity.User;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Method to find Todos by User
    List<Todo> findByUser(User user);
}
