package com.example.newswebsite.repository;

import com.example.newswebsite.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
