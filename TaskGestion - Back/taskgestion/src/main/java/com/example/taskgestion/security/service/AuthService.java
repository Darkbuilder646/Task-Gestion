package com.example.taskgestion.security.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.taskgestion.model.Users;
import com.example.taskgestion.payload.request.LoginRequest;
import com.example.taskgestion.payload.request.SignupRequest;
import com.example.taskgestion.payload.response.MessageResponse;
import com.example.taskgestion.repository.UsersRepository;

@Service
public class AuthService {
    private final UsersRepository usersRepository;

    public AuthService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public ResponseEntity<MessageResponse> signup(SignupRequest signupRequest) {
        if(usersRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already used"));
        }

        Users user = new Users(signupRequest.getUsername(), signupRequest.getEmail(), signupRequest.getPassword());

        usersRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("Success: User registered"));
    }

    public ResponseEntity<MessageResponse> login(LoginRequest loginRequest) {
        Optional<Users> optionalUser = usersRepository.findByEmail(loginRequest.getEmail());
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(new MessageResponse("Success: User login"));
            } else {
                return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Incorect Password"));
            }
        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: User not found"));
        }
    }
}
