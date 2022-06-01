package com.niit.project.restaurantservice.service;

import com.niit.project.restaurantservice.exception.RestaurantAlreadyExistException;
import com.niit.project.restaurantservice.exception.RestaurantNotFoundException;
import com.niit.project.restaurantservice.model.Restaurant;

import java.util.List;

public interface RestaurantService
{
    public abstract Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException;
    public abstract List<Restaurant> getAllRestaurants();
    public abstract List<Restaurant> getRestaurantByLocation(String location) throws RestaurantNotFoundException;
    public abstract List<Restaurant> getRestaurantByCuisineName(String cuisineName) throws RestaurantNotFoundException;
    public abstract List<Restaurant> getRestaurantByRestaurantName(String restaurantName) throws RestaurantNotFoundException;

    public abstract List<Restaurant> getRestaurantByLocationAndCuisineName(String location, String cuisineName) throws RestaurantNotFoundException;
    public abstract List<Restaurant> getRestaurantByLocationAndRestaurantName(String location, String restaurantName) throws RestaurantNotFoundException;
    public abstract Restaurant updateRestaurant(Restaurant restaurant);

}
