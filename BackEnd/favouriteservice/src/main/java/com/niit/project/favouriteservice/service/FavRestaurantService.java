package com.niit.project.favouriteservice.service;

import com.niit.project.favouriteservice.exception.RestaurantAlreadyExistException;
import com.niit.project.favouriteservice.model.FavouriteRestaurant;

import java.util.List;

public interface FavRestaurantService
{
    public abstract FavouriteRestaurant addFavRestaurant(FavouriteRestaurant favouriteRestaurant) throws RestaurantAlreadyExistException;
    public abstract List<FavouriteRestaurant> getAllFavRestaurant();
    public abstract boolean deleteByRestaurantId(long restaurantId);

    public abstract List<FavouriteRestaurant> getAllFavRestaurantByEmailId(String emailId);
    public abstract boolean deleteFavRestaurantByEmailIdAndRestaurantName(String emailId , String restaurantName);
}
