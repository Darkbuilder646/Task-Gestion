package com.example.taskgestion.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.taskgestion.dto.UsersDTO;
import com.example.taskgestion.model.Users;
import com.example.taskgestion.repository.UsersRepository;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public UsersDTO findUserById(Long id) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not-Found"));
        return modelMapper.map(user, UsersDTO.class);
    }

    public Users save(Users user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public Users update(Users user, Long id) throws Error {
        Users existingUser = usersRepository.findById(id).orElseThrow(() -> new Error("User not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword()); //! See later

        return usersRepository.save(existingUser);
    }
    
}
