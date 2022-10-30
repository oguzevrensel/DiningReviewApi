package com.example.DiningReviewApi.diningreviewapi.restaurant;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Boolean existsByPostCode(String postCode);
    Boolean existsByName (String name);
    Optional<Restaurant> findByPostCode(String postCode);
}
