package com.example.taskgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskgestion.model.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
