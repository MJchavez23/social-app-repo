package com.example.userservice.domain.model;

import java.util.UUID;

public class UserFollow {
    private UUID id;
    private User followed;
    private User follower;

    public UserFollow() {
    }

    public UserFollow(User followed, User follower) {
        this.followed = followed;
        this.follower = follower;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
