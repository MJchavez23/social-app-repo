package com.example.userservice.application.usecases;

import com.example.userservice.domain.model.User;
import com.example.userservice.domain.model.UserFollow;
import com.example.userservice.domain.model.exceptions.AlreadyFollowingException;
import com.example.userservice.domain.model.exceptions.CannotFollowSelfException;
import com.example.userservice.domain.model.exceptions.UserNotFoundException;
import com.example.userservice.domain.persistance.UserFollowRepository;
import com.example.userservice.domain.persistance.UserRepository;
import com.example.userservice.domain.usecases.FollowUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FollowUserUseCaseImpl implements FollowUserUseCase {

    private final UserRepository userRepository;
    private final UserFollowRepository userFollowRepository;

    @Override
    public void followUser(UUID currentUserId, UUID userToFollowId) throws UserNotFoundException, CannotFollowSelfException, AlreadyFollowingException {
        //Check if the follow already exist or if its following itself.
        alreadyFollowingCheck(currentUserId, userToFollowId);
        selfFollowCheck(currentUserId, userToFollowId);

        //Create the relation and save it
        User follower = userRepository.findById(currentUserId)
                .orElseThrow(() -> new UserNotFoundException(currentUserId));
        User followed = userRepository.findById(userToFollowId)
                .orElseThrow(() -> new UserNotFoundException(userToFollowId));

        UserFollow userFollow = new UserFollow(followed, follower);

        userFollowRepository.save(userFollow);
    }

    @Override
    public void unfollowUser(UUID currentUserId, UUID userToUnFollowId) {
        UserFollow userFollow = userFollowRepository.findByFollowedAndFollower(userToUnFollowId, currentUserId).orElseThrow();
        userFollowRepository.delete(userFollow);
    }


    private void selfFollowCheck(UUID currentUserId, UUID userToFollowId) throws CannotFollowSelfException {
        if(currentUserId.equals(userToFollowId)){
            throw new CannotFollowSelfException("You can not follow yourself");
        }
    }

    private void alreadyFollowingCheck(UUID currentUserId, UUID userToFollowId) throws AlreadyFollowingException {
        if(userFollowRepository.existsByFollowedAndFollowerId(userToFollowId, currentUserId)){
            throw new AlreadyFollowingException("You already following this user");
        }
    }
}
