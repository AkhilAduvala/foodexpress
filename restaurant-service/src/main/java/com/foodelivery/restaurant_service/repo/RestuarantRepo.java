package com.foodelivery.restaurant_service.repo;

import com.foodelivery.restaurant_service.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestuarantRepo extends JpaRepository<Restaurant, Integer> {
}
