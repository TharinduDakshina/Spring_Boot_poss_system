package com.example.SpringBoot_revition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item {
    @Id
    @Column(name = "item Id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    @Column(name = "item Name",length = 255)
    private String name;
    @Column(name = "unit_price",length = 45)
    private double unitPrice;
    @Column(name = "item qty",length = 100)
    private int qty;
}
