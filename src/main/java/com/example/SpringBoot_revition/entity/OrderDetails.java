package com.example.SpringBoot_revition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails {
    @Id
    @Column(name = "order_details_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "item Name",length = 255)
    private String name;

    @Column(name = "item qty",length = 50)
    private int item_qty;

    @Column(name = "amount",length = 50)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "code")
    private Item code;
}
