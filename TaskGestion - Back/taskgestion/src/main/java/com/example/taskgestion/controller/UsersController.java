package com.example.taskgestion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.taskgestion.dto.UsersDTO;
import com.example.taskgestion.model.Users;
import com.example.taskgestion.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    public final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/getUsers")
    public List<Users> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public UsersDTO findUserById(@PathVariable Long id) {
        return usersService.findUserById(id);
    }

    @PostMapping("")
    public Users save(@RequestBody Users user) {
        return usersService.save(user);
    }

    @PutMapping("/{id}")
    public Users update(@RequestBody Users user, @PathVariable Long id) throws Error {
        return usersService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }

}
