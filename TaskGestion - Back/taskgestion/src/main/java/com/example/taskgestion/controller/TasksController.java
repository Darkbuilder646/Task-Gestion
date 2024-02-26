package com.example.taskgestion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.taskgestion.dto.TasksDTO;
import com.example.taskgestion.model.Tasks;
import com.example.taskgestion.service.TasksService;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    
    public final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/getTasks")
    public List<Tasks> findAll() {
        return tasksService.findAll();
    }

    @GetMapping("/{id}")
    public TasksDTO findTaskById(@PathVariable Long id) {
        return tasksService.findTaskById(id);
    }

    @PostMapping("")
    public Tasks save(@RequestBody Tasks task) {
        return tasksService.save(task);
    }

    @PutMapping("/{id}")
    public Tasks update(@RequestBody Tasks task, @PathVariable Long id) {
        return tasksService.update(task, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasksService.deleteTask(id);
    }

}
