package com.restaurant.restaurantreviews.controller;

import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurantreviews.exception.ResourceNotFoundException;
import com.restaurant.restaurantreviews.model.Restaurant;
import com.restaurant.restaurantreviews.model.Review;
import com.restaurant.restaurantreviews.model.User;
import com.restaurant.restaurantreviews.repository.RestaurantRepository;
import com.restaurant.restaurantreviews.repository.ReviewRepository;
import com.restaurant.restaurantreviews.repository.UserRepository;
import com.restaurant.restaurantreviews.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    public ReviewController(ReviewService reviewService, RestaurantRepository restaurantRepository,
            UserRepository userRepository) {
        this.reviewService = reviewService;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, Object> jsonMap) {
        System.out.println(jsonMap.get("restaurant_id"));

        String comment = (String) jsonMap.get("comment");
        int restaurantId = (Integer) jsonMap.get("restaurant_id");
        long restaurantIdLong = (long) restaurantId;
        
        int userId = (Integer) jsonMap.get("user_id");
        long userIdLong = (long) userId;

        Restaurant restaurant = restaurantRepository.findById(restaurantIdLong)
        .orElseThrow(()-> new ResourceNotFoundException("Restaurant", restaurantIdLong));
        System.out.println(restaurant);

        User user = userRepository.findById(userIdLong)
        .orElseThrow(()-> new ResourceNotFoundException("User", userIdLong));
        System.out.println(user);

        Review review = new Review();
        review.setComment(comment);
        review.setRestaurant(restaurant);
        review.setUser(user);
        System.out.println(review);
        return new ResponseEntity<Review>(reviewService.saveReview(review), HttpStatus.CREATED);
    }
}
