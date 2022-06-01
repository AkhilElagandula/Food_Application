package com.niit.project.favouriteservice.service;

import com.niit.project.favouriteservice.exception.CuisineAlreadyExistException;
import com.niit.project.favouriteservice.model.FavouriteCuisine;
import com.niit.project.favouriteservice.model.FavouriteRestaurant;

import java.util.List;

public interface FavCuisineService
{
    public abstract FavouriteCuisine addFavCuisine(FavouriteCuisine favouriteCuisine) throws CuisineAlreadyExistException;
    public abstract List<FavouriteCuisine> getAllCuisine();
    public abstract boolean deleteByCuisineId(Long cuisineId);

    public abstract List<FavouriteCuisine> getAllFavCuisineByEmailId(String emailId);
}
