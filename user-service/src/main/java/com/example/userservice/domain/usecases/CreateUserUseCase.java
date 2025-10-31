package com.example.userservice.domain.usecases;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.exceptions.EmailAlreadyExistException;
import com.example.userservice.domain.model.exceptions.UsernameAlreadyExistException;

public interface CreateUserUseCase {
    User createUser(User user) throws EmailAlreadyExistException, UsernameAlreadyExistException;
}
