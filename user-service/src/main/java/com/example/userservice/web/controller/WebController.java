package com.example.userservice.web.controller;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.exceptions.EmailAlreadyExistException;
import com.example.userservice.domain.model.exceptions.UserNotFoundException;
import com.example.userservice.domain.model.exceptions.UsernameAlreadyExistException;
import com.example.userservice.domain.usecases.CreateUserUseCase;
import com.example.userservice.domain.usecases.FindUserUseCase;
import com.example.userservice.web.dto.RequestDto;
import com.example.userservice.web.mapper.WebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/user/")
public class WebController {

    private final WebMapper mapper;
    private final CreateUserUseCase createUserUseCase;
    private final FindUserUseCase findUserUseCase;

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody @Valid RequestDto requestDto) throws EmailAlreadyExistException, UsernameAlreadyExistException {
        User user = mapper.toModel(requestDto);
        createUserUseCase.createUser(user);
        return new ResponseEntity<>("User created Successfully",HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = findUserUseCase.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) throws UserNotFoundException {
        User user = findUserUseCase.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
