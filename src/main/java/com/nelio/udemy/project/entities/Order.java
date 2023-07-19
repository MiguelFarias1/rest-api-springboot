package com.nelio.udemy.project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelio.udemy.project.entities.enumns.OrderStatus;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "instant"})
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy 'T' HH:mm:ss 'Z'", timezone = "GMT")
    private Instant instant;

    private Integer status;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> orders = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private User client;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order(Long id, Instant instant, OrderStatus status, User client) {
        this.id = id;
        this.instant = instant;
        setOrderStatus(status);
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.fromInt(status);
    }

    public void setOrderStatus(OrderStatus status) {
        this.status = status.getCode();
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public Double getSomaTotal() {

        Double soma = 0.0;

        for(var item : orders) soma += item.getSubTotal();

        return soma;
    }
}
