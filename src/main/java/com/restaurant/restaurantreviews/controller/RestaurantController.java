package com.restaurant.restaurantreviews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantreviews.model.Restaurant;
import com.restaurant.restaurantreviews.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // Post a restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<Restaurant>(restaurantService.saveRestaurant(restaurant), HttpStatus.CREATED);
    }

    // Get all restaurants
    @GetMapping()
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        return new ResponseEntity<List<Restaurant>>(restaurantService.getRestaurants(), HttpStatus.OK);
    }

    // Get one restaurant
    @GetMapping("{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") Long restaurantId) {
        return new ResponseEntity<Restaurant>(restaurantService.getRestaurantById(restaurantId), HttpStatus.OK);
    }
}
