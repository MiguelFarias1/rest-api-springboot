package com.nelio.udemy.project.services;

import com.nelio.udemy.project.entities.Category;
import com.nelio.udemy.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {

        var category = categoryRepository.findById(id);

        if(category.isPresent()) return category.get();

        throw new IllegalArgumentException("Category not found !");
    }
}
