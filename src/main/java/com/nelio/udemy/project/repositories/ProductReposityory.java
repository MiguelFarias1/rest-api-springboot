package com.nelio.udemy.project.repositories;

import com.nelio.udemy.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposityory extends JpaRepository<Product, Long> {
}
