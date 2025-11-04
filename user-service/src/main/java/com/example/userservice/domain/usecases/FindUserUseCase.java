package com.example.userservice.domain.usecases;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.exceptions.UserNotFoundException;

import java.util.List;
import java.util.UUID;

public interface FindUserUseCase {
    User findById(UUID id) throws UserNotFoundException;
    List<User> findAllUsers();
}
