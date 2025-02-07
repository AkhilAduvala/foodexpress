package com.foodelivery.customer_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "Customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Customer_Id;
    private String Customer_Name;
    private String Customer_Address;
    private String Customer_Contact;
}
