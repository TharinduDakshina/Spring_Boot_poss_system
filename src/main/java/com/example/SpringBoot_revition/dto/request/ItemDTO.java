package com.example.SpringBoot_revition.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private int code;
    private String name;
    private double unitPrice;
    private int qty;
}
