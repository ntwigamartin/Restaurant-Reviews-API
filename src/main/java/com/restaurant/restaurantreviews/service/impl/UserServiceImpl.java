package com.restaurant.restaurantreviews.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurant.restaurantreviews.exception.ResourceNotFoundException;
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

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
        .orElseThrow(()-> new ResourceNotFoundException("User", userId));
    }

    @Override
    public User updateUser(Long userId, User user) {
        User userToUpdate = userRepository.findById(userId)
        .orElseThrow(()-> new ResourceNotFoundException("User", userId));;

        if (user.getUsername() != null) {
            userToUpdate.setUsername(user.getUsername());
        }

        if (user.getEmail() != null) {
            userToUpdate.setEmail(user.getEmail());
        }
        
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    @Override
    public void deleteUser(Long userId) {
        User userToDelete = userRepository.findById(userId)
        .orElseThrow(()-> new ResourceNotFoundException("User", userId));;

        userRepository.delete(userToDelete);
    }
    
}
