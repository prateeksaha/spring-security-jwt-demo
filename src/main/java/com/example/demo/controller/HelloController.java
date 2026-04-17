package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Public Hello!";
    }

    @GetMapping("/api/secure")
    public String secureHello() {
        return "Secure Hello!";
    }
}