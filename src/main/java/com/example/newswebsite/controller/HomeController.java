package com.example.newswebsite.controller;


import com.example.newswebsite.model.Category;
import com.example.newswebsite.model.News;
import com.example.newswebsite.service.CategoryService;
import com.example.newswebsite.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final CategoryService categoryService;
    private final NewsService newsService;

    public HomeController(CategoryService categoryService, NewsService newsService) {
        this.categoryService = categoryService;
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/category/{id}")
    public String newsByCategory(@PathVariable("id") Long categoryId, Model model) {
        List<News> newsList = newsService.getNewsByCategory(categoryId);
        model.addAttribute("newsList", newsList);
        return "newsList";
    }

    @GetMapping("/news/{id}")
    public String newsDetails(@PathVariable("id") Long newsId, Model model) {
        News news = newsService.getNewsById(newsId).orElseThrow(() -> new IllegalArgumentException("Invalid news ID"));
        model.addAttribute("news", news);
        return "newsDetails";
    }
}
