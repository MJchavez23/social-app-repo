package org.example.postservice.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime postedAt;
    private UserDetails userDetails;
}
