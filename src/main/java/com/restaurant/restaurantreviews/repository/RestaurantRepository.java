package com.restaurant.restaurantreviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.restaurantreviews.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
    
}
