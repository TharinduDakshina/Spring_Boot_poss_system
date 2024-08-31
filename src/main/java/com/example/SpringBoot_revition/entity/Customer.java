package com.example.SpringBoot_revition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @Column(name = "Customer Id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_Id;
    @Column(name = "Customer Name",length = 100,nullable = false)
    private String name;
    @Column(name = "Address",length = 255)
    private String address;
    @Column(name = "Contact number")
    private String contactNo;

}
