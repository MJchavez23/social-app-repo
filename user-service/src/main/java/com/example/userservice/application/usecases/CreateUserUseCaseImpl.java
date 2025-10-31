package com.example.userservice.application.usecases;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.exceptions.EmailAlreadyExistException;
import com.example.userservice.domain.model.exceptions.UsernameAlreadyExistException;
import com.example.userservice.domain.persistance.UserRepository;
import com.example.userservice.domain.usecases.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) throws EmailAlreadyExistException, UsernameAlreadyExistException {
        checkUnique(user.getEmail(), user.getUsername());
        return userRepository.save(user);
    }

    private void checkUnique(String email, String username) throws EmailAlreadyExistException, UsernameAlreadyExistException {
        if(userRepository.existByEmail(email)){
            throw new EmailAlreadyExistException("Email: " + email + " already exists");
        }
        if(userRepository.existByUsername(username)){
            throw new UsernameAlreadyExistException("Username" + username + " already exist");
        }
    }

}
