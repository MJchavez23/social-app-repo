package com.example.userservice.domain.model;

import java.util.UUID;

public class UserFollow {
    private UUID id;
    private User followed;
    private User follower;
}
