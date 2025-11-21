package org.example.postservice.infrastructure.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class UserDetailsEntity {

    @Id
    @GeneratedValue()
    private UUID id;

    private UUID userId;

    private String username;

    private String bio;
}
