package com.example.newswebsite.service;

import com.example.newswebsite.model.News;
import com.example.newswebsite.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getNewsByCategory(Long categoryId) {
        return newsRepository.findByCategoriesId(categoryId);
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }
}
