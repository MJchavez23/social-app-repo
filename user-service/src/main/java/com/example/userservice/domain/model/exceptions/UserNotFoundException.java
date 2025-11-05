package com.example.userservice.domain.model.exceptions;

import java.util.UUID;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(UUID userId) {
        super("User with id " + userId + " not found");
    }
}
