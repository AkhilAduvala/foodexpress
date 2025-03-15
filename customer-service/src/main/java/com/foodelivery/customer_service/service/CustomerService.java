package com.foodelivery.customer_service.service;

import com.foodelivery.customer_service.dto.CustomerDto;
import com.foodelivery.customer_service.exception.CustomerNotFoundException;
import com.foodelivery.customer_service.model.Customer;
import com.foodelivery.customer_service.repo.CustomerRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    @Cacheable(value = "allcustomers", key = "#customerId")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customersDto = new ArrayList<>();
        List<Customer> customers = customerRepo.findAll();
        for (Customer customer : customers){
            CustomerDto customerDto = new CustomerDto();

            customerDto.setCustomerId(customer.getCustomer_Id());
            customerDto.setCustomerName(customer.getCustomer_Name());
            customerDto.setCustomerAddress(customer.getCustomer_Address());
            customerDto.setCustomerContact(customer.getCustomer_Contact());

            customersDto.add(customerDto);
        }

        return new ResponseEntity<>(customersDto, HttpStatus.OK);
    }

    @Cacheable(value = "customer", key = "#customerId")
    public ResponseEntity<CustomerDto> getCustomer(int customerId){
        CustomerDto customerDto = new CustomerDto();

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Unable to find the customer with Id : "
                        + customerId));

        customerDto.setCustomerId(customer.getCustomer_Id());
        customerDto.setCustomerName(customer.getCustomer_Name());
        customerDto.setCustomerAddress(customer.getCustomer_Address());
        customerDto.setCustomerContact(customer.getCustomer_Contact());

        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    public ResponseEntity<CustomerDto> newCustomer(CustomerDto customerDto){
        Customer customer = new Customer();

        customer.setCustomer_Id(customerDto.getCustomerId());
        customer.setCustomer_Name(customerDto.getCustomerName());
        customer.setCustomer_Address(customerDto.getCustomerAddress());
        customer.setCustomer_Contact(customerDto.getCustomerContact());

        customerRepo.save(customer);

        return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @CachePut(value = "allcustomers", key = "#customerId")
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto  customerDto){
        Customer customer = new Customer();

        customer.setCustomer_Id(customerDto.getCustomerId());
        customer.setCustomer_Name(customerDto.getCustomerName());
        customer.setCustomer_Address(customerDto.getCustomerAddress());
        customer.setCustomer_Contact(customerDto.getCustomerContact());

        Customer customerDetails = customerRepo.findById(customer.getCustomer_Id())
                .orElseThrow(() -> new CustomerNotFoundException("Unable to find the customer with Id : "
                        + customerDto.getCustomerId()));

        customerRepo.save(customer);
        return new ResponseEntity<CustomerDto>(customerDto, HttpStatus.OK);
    }

    @CacheEvict(value = "allcustomers", key = "#customerId")
    public ResponseEntity<Void> deleteCustomer(int customerId){
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Unable to find the customer with Id : "
                        + customerId));

        customerRepo.deleteById(customer.getCustomer_Id());
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }

}
