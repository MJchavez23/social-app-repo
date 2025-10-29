package com.example.userservice.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;

    private String email;

    private String bio;

    @OneToMany(mappedBy = "followed", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserFollowEntity> followers = new HashSet<>();

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL,  orphanRemoval = true)
    private Set<UserFollowEntity> following  = new HashSet<>();
}
