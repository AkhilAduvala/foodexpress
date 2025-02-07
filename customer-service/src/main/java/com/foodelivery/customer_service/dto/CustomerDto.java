package com.foodelivery.customer_service.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerContact;
}
