package com.example.demo.controller;

import com.example.demo.util.JwtUtil;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;

    public AuthController(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        return JwtUtil.generateToken(username);
    }
}