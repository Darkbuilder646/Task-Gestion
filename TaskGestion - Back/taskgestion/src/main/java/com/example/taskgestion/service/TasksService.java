package com.example.taskgestion.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import com.example.taskgestion.dto.TasksDTO;
import com.example.taskgestion.model.Tasks;
import com.example.taskgestion.repository.TasksRepository;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;
    private final ModelMapper modelMapper;

    public TasksService(TasksRepository tasksRepository, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
    }

    public List<Tasks> findAll() {
        return tasksRepository.findAll();
    }

    public TasksDTO findTaskById(Long id) {
        Tasks task = tasksRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Task Not-Found"));
        return modelMapper.map(task, TasksDTO.class);
    }

    public Tasks save(Tasks task) {
        return tasksRepository.save(task);
    }

    public void deleteTask(Long id) {
        tasksRepository.deleteById(id);
    }

    public Tasks update(Tasks task, Long id) throws Error {
        Tasks existingTask = tasksRepository.findById(id).orElseThrow(() -> new Error("User not found"));
        existingTask.setTag(task.getTag());
        existingTask.setDescription(task.getDescription());

        return tasksRepository.save(existingTask);
    }
    
}
