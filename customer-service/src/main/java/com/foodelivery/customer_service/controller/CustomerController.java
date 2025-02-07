package com.foodelivery.customer_service.controller;

import com.foodelivery.customer_service.dto.CustomerDto;
import com.foodelivery.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{CId}")
    public ResponseEntity<CustomerDto> getCustomer(int customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> newCustomer(@RequestBody CustomerDto customerDto){
        return customerService.newCustomer(customerDto);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/{CId}")
    public ResponseEntity<Void> deleteCustomer(int customerId){
        return customerService.deleteCustomer(customerId);
    }
}
