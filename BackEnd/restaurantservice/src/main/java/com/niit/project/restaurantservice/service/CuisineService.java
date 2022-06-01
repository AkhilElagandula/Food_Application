package com.niit.project.restaurantservice.service;

import com.niit.project.restaurantservice.exception.CuisineAlreadyExistException;
import com.niit.project.restaurantservice.model.Cuisine;

import java.util.List;

public interface CuisineService
{
    public abstract Cuisine addCuisine(Cuisine cuisine) throws CuisineAlreadyExistException;
    public abstract List<Cuisine> getAllCuisine();

}
