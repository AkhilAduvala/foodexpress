package com.foodelivery.order_service.dto;

public record MenuDto(int itemId, Integer restaurantId, String itemName, Double price) {
}
