package com.todoapp.SimpleApp.dto;

public class AuthRequest {

    private String username;
    private String password;

    // Constructors, getters, and setters

    public AuthRequest() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
