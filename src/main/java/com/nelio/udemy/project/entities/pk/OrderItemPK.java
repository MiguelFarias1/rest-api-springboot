package com.nelio.udemy.project.entities.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelio.udemy.project.entities.Order;
import com.nelio.udemy.project.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.io.Serializable;

@Setter
@EqualsAndHashCode(of = {"product", "order"})
@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    public Product getProduct() {
        return product;
    }

    @JsonIgnore
    public Order getOrder() {
        return order;
    }
}
