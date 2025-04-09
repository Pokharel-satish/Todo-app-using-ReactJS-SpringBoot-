package com.todoapp.SimpleApp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.SimpleApp.entity.Todo;
import com.todoapp.SimpleApp.entity.User;
import com.todoapp.SimpleApp.repository.TodoRepository;
import com.todoapp.SimpleApp.repository.UserRepository;
// ... other imports

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()
        ).orElseThrow();
        return ResponseEntity.ok(todoRepository.findByUser(user));
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName()
        ).orElseThrow();
        todo.setUser(user);
        return ResponseEntity.ok(todoRepository.save(todo));
    }
}
