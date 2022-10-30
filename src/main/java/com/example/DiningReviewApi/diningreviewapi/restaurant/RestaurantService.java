package com.example.DiningReviewApi.diningreviewapi.restaurant;

import com.example.DiningReviewApi.diningreviewapi.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    public void addNewRestaurant(Restaurant restaurant) {

        restaurantRepository.save(restaurant);
        System.out.println(restaurant);
    }

    public void deleteRestaurant(Long restaurantId) {
        boolean existsRestaurant = restaurantRepository.existsById(restaurantId);
        if (!existsRestaurant) {
            throw new IllegalStateException("Restaurant with id " + restaurantId + " does not exist");
        }
        restaurantRepository.deleteById(restaurantId);
    }

    public void updateRestaurant(Long restaurantId,
                           String restaurantName,
                           String postcode,
                           String cuisine
    ) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalStateException("Restaurant with id " + restaurantId + " does not exist"));

        if (restaurantName != null && restaurantName.length() > 0 && !Objects.equals(restaurant.getName(), restaurantName)) {
            restaurant.setName(restaurantName);
        }

        if (postcode != null && postcode.length() > 0 && !Objects.equals(restaurant.getPostCode(), postcode)) {
            restaurant.setPostCode(postcode);
        }

        if (cuisine != null && cuisine.length() > 0 && !Objects.equals(restaurant.getCuisine(), cuisine)) {
            restaurant.setCuisine(cuisine);
        }

    }
}
