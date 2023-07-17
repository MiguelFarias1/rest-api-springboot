package com.nelio.udemy.project.services;

import com.nelio.udemy.project.entities.Product;
import com.nelio.udemy.project.repositories.ProductReposityory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductReposityory productReposityory;

    public List<Product> findAll() {return productReposityory.findAll();}

    public Product findById(Long id) {
        Optional<Product> product = productReposityory.findById(id);

        if(product.isPresent()) return product.get();

        else
            throw new IllegalArgumentException("Order not found !");
    }
}
