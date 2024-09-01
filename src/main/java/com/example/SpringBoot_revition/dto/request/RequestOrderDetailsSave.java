package com.example.SpringBoot_revition.dto.request;

import com.example.SpringBoot_revition.entity.Item;
import com.example.SpringBoot_revition.entity.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSave {
    private String name;
    private int item_qty;
    private double amount;
    private int orders;
    private int code;
}
