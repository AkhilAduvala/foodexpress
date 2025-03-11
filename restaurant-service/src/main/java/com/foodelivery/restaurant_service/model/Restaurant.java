package com.foodelivery.restaurant_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Restaurants")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;

    private String restaurantName;

    private String address;

    private String phoneNo;
}
