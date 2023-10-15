package com.restaurant.restaurantreviews.service;

import java.util.List;

import com.restaurant.restaurantreviews.model.User;

public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
}
