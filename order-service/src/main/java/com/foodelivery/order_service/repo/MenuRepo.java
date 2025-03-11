package com.foodelivery.order_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodelivery.order_service.model.Menu;

import java.util.List;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

    List<Menu> findByRestaurantId(int restaurantId);
}
