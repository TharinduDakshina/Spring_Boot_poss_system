package com.example.SpringBoot_revition.service;

import com.example.SpringBoot_revition.dto.request.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    boolean addCustomer(CustomerDTO customerDTO);

    ArrayList<CustomerDTO> getAll();

    boolean updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerByName(String customerName);
}
