package com.example.newswebsite.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

    @Column(nullable = false)
    private String author;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "date_posted")
    private LocalDateTime datePosted = LocalDateTime.now();
}
