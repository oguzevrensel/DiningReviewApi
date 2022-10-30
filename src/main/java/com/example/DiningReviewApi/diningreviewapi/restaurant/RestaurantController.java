package com.example.DiningReviewApi.diningreviewapi.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping(path = "/{restaurantId}")
    public Optional<Restaurant> getRestaurant(@PathVariable(value = "restaurantId") Long id) {
        return restaurantService.getRestaurant(id);
    }

    @PostMapping
    public void registerNewRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addNewRestaurant(restaurant);
    }

    @DeleteMapping(path = "{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
    }

    @PutMapping(path = "{restaurantId}")
    public void updateRestaurant(
            @PathVariable("restaurantId") Long restaurantId,
            @RequestParam(required = false) String restaurantName,
            @RequestParam(required = false) String postcode,
            @RequestParam(required = false) String cuisine)
    {
        restaurantService.updateRestaurant(restaurantId, restaurantName, postcode, cuisine);
    }
}
