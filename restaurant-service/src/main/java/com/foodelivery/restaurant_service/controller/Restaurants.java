package com.foodelivery.restaurant_service.controller;

import com.foodelivery.restaurant_service.dto.RestuarantDTO;
import com.foodelivery.restaurant_service.model.Restaurant;
import com.foodelivery.restaurant_service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/restaurants")
@RestController
public class Restaurants {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<RestuarantDTO> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public RestuarantDTO getRestaurant(@PathVariable int restaurantId){
        return restaurantService.getRestaurant(restaurantId);
    }

    @PostMapping
    public ResponseEntity<RestuarantDTO> addRestaurants(@RequestBody List<Restaurant> restaurants){
        return restaurantService.addRestuarants(restaurants);
    }

    @PutMapping
    public RestuarantDTO updateRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRestuarant(@PathVariable int restaurantId){
        return restaurantService.deleteRestaurant(restaurantId);
    }
}
