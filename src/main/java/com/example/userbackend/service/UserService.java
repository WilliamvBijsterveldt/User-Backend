package com.example.userbackend.service;

import com.example.userbackend.model.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(User user, long id);
    void deleteUser(long id);
    User loginUser(String username, String password);
}
