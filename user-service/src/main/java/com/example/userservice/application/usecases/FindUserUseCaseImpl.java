package com.example.userservice.application.usecases;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.exceptions.UserNotFoundException;
import com.example.userservice.domain.persistance.UserRepository;
import com.example.userservice.domain.usecases.FindUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class FindUserUseCaseImpl implements FindUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User findById(UUID id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
