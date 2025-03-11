package com.foodelivery.restaurant_service.service;

import com.foodelivery.restaurant_service.dto.RestuarantDTO;
import com.foodelivery.restaurant_service.model.Restaurant;
import com.foodelivery.restaurant_service.repo.RestuarantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestuarantRepo restuarantRepo;

    @Autowired
    public RestaurantService(RestuarantRepo restuarantRepo){
        this.restuarantRepo = restuarantRepo;
    }

    public List<RestuarantDTO> getAllRestaurants() {
        List<Restaurant> restaurant = restuarantRepo.findAll();

    }

    public RestuarantDTO getRestaurant(int restaurantId) {
        Optional<Restaurant> restaurant = restuarantRepo.findById(restaurantId);
        return new RestuarantDTO(restaurant.get().getRestaurantId(), restaurant.get().getRestaurantName(),
                restaurant.get().getAddress(), restaurant.get().getPhoneNo());
    }

    public ResponseEntity<RestuarantDTO> addRestuarants(List<Restaurant> restaurants) {
        restuarantRepo.saveAll(restaurants);
    }

    public RestuarantDTO updateRestaurant(Restaurant restaurant) {
        restuarantRepo.save(restaurant);
    }

    public ResponseEntity deleteRestaurant(int restaurantId) {
        restuarantRepo.deleteById(restaurantId);
    }
}
