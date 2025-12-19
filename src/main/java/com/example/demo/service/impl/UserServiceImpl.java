package com.example.demo.service.impl;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.dto.*;
import com.example.demo.model.User;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }
}
