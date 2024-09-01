package com.example.SpringBoot_revition.entity;

import com.example.SpringBoot_revition.entity.enums.MeasuringUnitTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",length = 25)
    private MeasuringUnitTypes measuringUnitTypes;

    @Column(name = "unit_price",length = 45)
    private double unitPrice;

    @Column(name = "item qty",length = 50)
    private int qty;

    @OneToMany(mappedBy = "code")
    private Set<OrderDetails> orderDetails;
}
