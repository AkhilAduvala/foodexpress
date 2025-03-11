package com.foodelivery.order_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Menu")
public class Menu {

    @Id
    private int itemId;
    private int restaurantId;
    private String itemName;
    private double price;
}
