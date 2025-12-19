package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterRequest request) {
        return User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Set.of("ROLE_USER"))
                .build();
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        return new AuthResponse("dummy-token", request.getEmail(), Set.of("ROLE_USER"));
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }
}
