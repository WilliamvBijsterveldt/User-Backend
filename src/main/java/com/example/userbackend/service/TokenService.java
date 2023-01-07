package com.example.userbackend.service;

import org.springframework.security.core.Authentication;

public interface TokenService {
    
    String generateToken(Authentication authentication);
}
