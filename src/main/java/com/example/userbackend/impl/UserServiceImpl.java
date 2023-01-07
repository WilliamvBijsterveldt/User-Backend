package com.example.userbackend.impl;

import com.example.userbackend.exception.ResourceNotFoundException;
import com.example.userbackend.model.User;
import com.example.userbackend.repository.UserRepository;
import com.example.userbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public User updateUser(User user, long id) {
        User oldUser = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));

        oldUser.setEmail(user.getEmail());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setDateOfBirth(user.getDateOfBirth());

        userRepository.save(oldUser);

        return oldUser;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));

        userRepository.deleteById(id);
    }

    @Override
    public User userLogin(String email, String password) {
        return null;
    }
}
