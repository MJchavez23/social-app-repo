package org.example.postservice.infrastructure.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.postservice.domain.model.UserDetails;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class PostEntity {
    @Id
    @GeneratedValue()
    private UUID id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime postedAt;

    private UserDetails userDetails;
}
