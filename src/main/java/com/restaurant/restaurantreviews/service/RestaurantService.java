package com.restaurant.restaurantreviews.service;

import java.util.List;

import com.restaurant.restaurantreviews.model.Restaurant;

public interface RestaurantService {
    Restaurant saveRestaurant(Restaurant restaurant);
    List<Restaurant> getRestaurants();
}
