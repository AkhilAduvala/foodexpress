package com.foodelivery.customer_service.controller;

import com.foodelivery.customer_service.dto.CustomerDto;
import com.foodelivery.customer_service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

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
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("CId") int customerId){
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
    public ResponseEntity<Void> deleteCustomer(@PathVariable("CId") int customerId){
        return customerService.deleteCustomer(customerId);
    }
}
