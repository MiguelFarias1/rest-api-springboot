package com.nelio.udemy.project.services;

import com.nelio.udemy.project.entities.Product;
import com.nelio.udemy.project.repositories.ProductReposityory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductReposityory productReposityory;

    public ProductService(ProductReposityory productReposityory) {
        this.productReposityory = productReposityory;
    }

    public List<Product> findAll() {return productReposityory.findAll();}

    public Product findById(Long id) {
        Optional<Product> product = productReposityory.findById(id);

        if(product.isPresent()) return product.get();

        else
            throw new IllegalArgumentException("Order not found !");
    }
}
