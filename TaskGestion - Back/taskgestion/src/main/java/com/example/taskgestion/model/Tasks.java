package com.example.taskgestion.model;

import java.io.Serializable;

import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Tasks implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String tag;

    // @NotNull
    private String description;

    public Tasks(String tag, String description) {
        this.tag = tag;
        this.description = description;
    }
}
