package com.example.demo.security;

import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email, Set<String> roles) {
        return "dummy-token";
    }

    public Map<String, Object> getClaims(String token) {
        return Map.of("email", "dummy@example.com");
    }
}
