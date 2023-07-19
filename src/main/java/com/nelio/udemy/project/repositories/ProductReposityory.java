package com.nelio.udemy.project.repositories;

import com.nelio.udemy.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReposityory extends JpaRepository<Product, Long> {
}
