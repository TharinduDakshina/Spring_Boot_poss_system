package com.example.SpringBoot_revition.service.impl;

import com.example.SpringBoot_revition.dto.request.CustomerDTO;
import com.example.SpringBoot_revition.entity.Customer;
import com.example.SpringBoot_revition.repository.CustomerRepo;
import com.example.SpringBoot_revition.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer(
                customerDTO.getCustomer_Id(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContactNo()
        );

        if (!customerRepo.existsById(customer.getCustomer_Id())) {
            customerRepo.save(customer);
            return true;
        }{
            System.out.println("already exits");
            return false;
        }

    }

    @Override
    public ArrayList<CustomerDTO> getAll() {
        ArrayList<Customer> all = (ArrayList<Customer>) customerRepo.findAll();
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();

        allCustomers = modelMapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {}.getType());

        return allCustomers;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {

        if (customerRepo.existsById(customerDTO.getCustomer_Id())) {
            Customer customer = customerRepo.getReferenceById(customerDTO.getCustomer_Id());
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            customer.setContactNo(customerDTO.getContactNo());

            customerRepo.save(customer);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public CustomerDTO getCustomerByName(String customerName) {

        Customer customer = customerRepo.getByName(customerName);
        return modelMapper.map(customer,CustomerDTO.class);
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        customerRepo.deleteById(customerId);
        return  true;
    }
}
