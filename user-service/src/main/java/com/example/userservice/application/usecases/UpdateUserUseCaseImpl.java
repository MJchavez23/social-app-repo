package com.example.userservice.application.usecases;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.exceptions.UserNotFoundException;
import com.example.userservice.domain.model.exceptions.UsernameAlreadyExistException;
import com.example.userservice.domain.persistance.UserRepository;
import com.example.userservice.domain.usecases.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User updateBio(UUID id, String bio) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() ->  new UserNotFoundException(id));
        user.setBio(bio);
        return userRepository.save(user);
    }

    @Override
    public User updateUsername(UUID id, String username) throws UserNotFoundException, UsernameAlreadyExistException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        if(userRepository.existByUsername(username)){
            throw new UsernameAlreadyExistException(username);
        }
        user.setUsername(username);
        return userRepository.save(user);
    }
}
