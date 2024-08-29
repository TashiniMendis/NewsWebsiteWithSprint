package com.example.newswebsite.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity

public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "date_published")
    private LocalDateTime datePublished = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "news_category",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    @OneToMany(mappedBy = "news")
    private Set<Comment> comments;
}
