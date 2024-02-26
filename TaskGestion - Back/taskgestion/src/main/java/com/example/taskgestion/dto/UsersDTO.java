package com.example.taskgestion.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsersDTO implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String password;
}
