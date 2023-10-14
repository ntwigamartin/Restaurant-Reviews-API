package com.restaurant.restaurantreviews.service.impl;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantreviews.model.User;
import com.restaurant.restaurantreviews.repository.UserRepository;
import com.restaurant.restaurantreviews.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
}
