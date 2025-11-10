package com.example.userservice.domain.model.exceptions;

public class EmailAlreadyExistException extends Throwable {
    public EmailAlreadyExistException(String email) {
        super("Email already exists: " + email);
    }
}
