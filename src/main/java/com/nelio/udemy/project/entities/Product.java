package com.nelio.udemy.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imgURL;

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> orders = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Product(String name, String description, BigDecimal price, String imgURL) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgURL = imgURL;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();

        for(var element : orders) {
            set.add(element.getOrder());
        }

        return set;
    }


}