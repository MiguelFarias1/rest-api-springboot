package com.nelio.udemy.project.resources;

import com.nelio.udemy.project.entities.Category;
import com.nelio.udemy.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        var list = categoryService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Category> findById(@PathVariable(name = "id") Long id) {

        var category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }
}
