package com.example.SpringBoot_revition.dto.request;

import com.example.SpringBoot_revition.entity.Customer;
import com.example.SpringBoot_revition.entity.OrderDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSave {
    private int customer;
    private Date date;
    private Double total;
    private ArrayList<RequestOrderDetailsSave> requestOrderDetailsSaves;
}
