package com.example.SpringBoot_revition.dto.request;

import com.example.SpringBoot_revition.entity.enums.MeasuringUnitTypes;
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
    private MeasuringUnitTypes measuringUnitTypes;
    private int qty;

    public ItemDTO(String name, double unitPrice, MeasuringUnitTypes measuringUnitTypes, int qty) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.measuringUnitTypes = measuringUnitTypes;
        this.qty = qty;
    }
}
