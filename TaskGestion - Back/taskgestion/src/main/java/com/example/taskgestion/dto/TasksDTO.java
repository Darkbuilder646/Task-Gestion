package com.example.taskgestion.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TasksDTO implements Serializable {
    private Long id;
    private String tag;
    private String description;
}
