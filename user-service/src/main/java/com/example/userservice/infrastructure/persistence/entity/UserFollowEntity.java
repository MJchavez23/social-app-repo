package com.example.userservice.infrastructure.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class UserFollowEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followed_id")
    private UserEntity followed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    private UserEntity follower;
}
