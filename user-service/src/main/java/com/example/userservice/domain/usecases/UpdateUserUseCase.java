package com.example.userservice.domain.usecases;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.exceptions.UserNotFoundException;
import com.example.userservice.domain.model.exceptions.UsernameAlreadyExistException;

import java.util.UUID;

public interface UpdateUserUseCase {
    User updateBio(UUID id, String bio) throws UserNotFoundException;
    User updateUsername(UUID id, String username) throws UserNotFoundException, UsernameAlreadyExistException;
}
