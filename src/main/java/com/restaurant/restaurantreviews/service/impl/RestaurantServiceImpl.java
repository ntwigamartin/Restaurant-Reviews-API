package com.restaurant.restaurantreviews.service.impl;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantreviews.model.Restaurant;
import com.restaurant.restaurantreviews.repository.RestaurantRepository;
import com.restaurant.restaurantreviews.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;
    
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setLocation(restaurant.getLocation());
        restaurantRepository.save(newRestaurant);
        return newRestaurant;
    }
    
}
