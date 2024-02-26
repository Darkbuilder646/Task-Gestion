package com.example.taskgestion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.taskgestion.payload.request.LoginRequest;
import com.example.taskgestion.payload.request.SignupRequest;
import com.example.taskgestion.security.service.AuthService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> SignUp(@Valid @RequestBody SignupRequest signupRequest) {
        return (ResponseEntity<?>) authService.signup(signupRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> Login(@Valid @RequestBody LoginRequest loginRequest) {
        return (ResponseEntity<?>) authService.login(loginRequest);
    }
}
