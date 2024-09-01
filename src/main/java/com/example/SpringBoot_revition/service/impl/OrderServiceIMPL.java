package com.example.SpringBoot_revition.service.impl;

import com.example.SpringBoot_revition.dto.request.RequestOrderSave;
import com.example.SpringBoot_revition.entity.OrderDetails;
import com.example.SpringBoot_revition.entity.Orders;
import com.example.SpringBoot_revition.repository.CustomerRepo;
import com.example.SpringBoot_revition.repository.ItemRepo;
import com.example.SpringBoot_revition.repository.OrderDetailsRepo;
import com.example.SpringBoot_revition.repository.OrderRepo;
import com.example.SpringBoot_revition.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String add(RequestOrderSave requestOrderSave) {
        Orders orders = new Orders(
                customerRepo.getById(requestOrderSave.getCustomer()),
                requestOrderSave.getDate(),
                requestOrderSave.getTotal()
        );

        orderRepo.save(orders);

        if (orderRepo.existsById(orders.getOrder_id())) {
            ArrayList<OrderDetails> orderDetails = modelMapper.map
                    (requestOrderSave.getRequestOrderDetailsSaves(), new TypeToken<ArrayList<OrderDetails>>() {
                    }.getType());



            for (int i = 0; i < orderDetails.size(); i++) {
                orderDetails.get(i).setOrders(orders);
                orderDetails.get(i).setCode(
                        itemRepo.getById(
                                requestOrderSave.getRequestOrderDetailsSaves().get(i).getCode()
                        )
                );
            }

            if (orderDetails.size()>0) {
                orderDetailsRepo.saveAll(orderDetails);
                return "save";
            }else {
                return "order details failed";
            }

        }else {
            return "order save process is failed. ";
        }
    }
}
