package com.ea.miushop.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "order")
    private List<Item> items;

    private LocalDate orderDate;

    private boolean orderBought;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
