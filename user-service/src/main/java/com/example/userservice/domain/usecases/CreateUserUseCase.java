package com.example.userservice.domain.usecases;

import com.example.userservice.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
