package com.example.userservice.domain.model.exceptions;

public class UsernameAlreadyExistException extends Throwable {
    public UsernameAlreadyExistException(String username) {
        super("Username already exists: " + username);
    }
}
