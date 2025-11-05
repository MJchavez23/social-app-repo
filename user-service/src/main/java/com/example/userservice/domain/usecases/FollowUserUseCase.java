package com.example.userservice.domain.usecases;

import com.example.userservice.domain.model.exceptions.AlreadyFollowingException;
import com.example.userservice.domain.model.exceptions.CannotFollowSelfException;
import com.example.userservice.domain.model.exceptions.UserNotFoundException;

import java.util.UUID;

public interface FollowUserUseCase {
    void followUser(UUID currentUserId, UUID userToFollowId) throws UserNotFoundException, CannotFollowSelfException, AlreadyFollowingException;
    void unfollowUser(UUID currentUserId, UUID userToUnFollowId);
}
