package com.example.newswebsite.repository;

import com.example.newswebsite.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByCategoriesId(Long categoryId);
}
