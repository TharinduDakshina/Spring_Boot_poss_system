package com.example.SpringBoot_revition.controler;

import com.example.SpringBoot_revition.dto.request.CustomerDTO;
import com.example.SpringBoot_revition.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/getAll")
    public ArrayList<CustomerDTO> getAllCustomers(){
       ArrayList<CustomerDTO> allCustomers=customerService.getAll();
       return allCustomers;
    }

    @GetMapping(value = "/getCustomerByName",params = "name")
    public CustomerDTO getCustomerByName(@RequestParam(value = "name")String customerName){
        return customerService.getCustomerByName(customerName);
    }

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {

        if (customerService.addCustomer(customerDTO)) {
            return "save customer";
        } else {
            return "already exits";
        }
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        if (customerService.updateCustomer(customerDTO)) {
            return "updated customer";
        }else {
            return "Customer not found";
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        if (customerService.deleteCustomer(customerId)) {
            return "Deleted";
        }else return "Delete process field";

    }
}
