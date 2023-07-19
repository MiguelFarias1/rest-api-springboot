package com.nelio.udemy.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"id", "moment"})
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @OneToOne
    @MapsId(value = "")
    @JsonIgnore
    private Order order;

    public Payment(Instant moment, Order order) {
        this.moment = moment;
        this.order = order;
    }
}
