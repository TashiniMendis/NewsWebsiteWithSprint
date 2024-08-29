package com.example.newswebsite.model;

import java.util.Set;


import com.example.newswebsite.NewsWebsiteApplication;
import jakarta.persistence.*;



@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<News> news;
}
