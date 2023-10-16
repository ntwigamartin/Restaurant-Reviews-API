package com.restaurant.restaurantreviews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantreviews.model.Restaurant;
import com.restaurant.restaurantreviews.model.User;
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

    // update restaurant
    @PutMapping("{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Long restaurantId, @RequestBody Restaurant restaurant) {
        return new ResponseEntity<Restaurant>(restaurantService.updateRestaurant(restaurantId, restaurant), HttpStatus.OK);
    }

    // Delete restaurant
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable("id") Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return new ResponseEntity<String>("Restaurant with id " + restaurantId + " deleted successfully", HttpStatus.OK);
    }
}
