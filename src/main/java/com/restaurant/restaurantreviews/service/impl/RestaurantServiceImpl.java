package com.restaurant.restaurantreviews.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantreviews.exception.ResourceNotFoundException;
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

    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId)
        .orElseThrow(()-> new ResourceNotFoundException("Restaurant", restaurantId));
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, Restaurant restaurant) {
         Restaurant restaurantToUpdate = restaurantRepository.findById(restaurantId)
        .orElseThrow(()-> new ResourceNotFoundException("Restaurant", restaurantId));;

        if (restaurant.getName() != null) {
            restaurantToUpdate.setName(restaurant.getName());
        }

        if (restaurant.getLocation() != null) {
            restaurantToUpdate.setLocation(restaurant.getLocation());
        }
        
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
        .orElseThrow(()-> new ResourceNotFoundException("Restaurant", restaurantId));

        restaurantRepository.delete(restaurant);
    }
    
}
