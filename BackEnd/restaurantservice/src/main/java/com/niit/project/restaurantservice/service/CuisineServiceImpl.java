package com.niit.project.restaurantservice.service;

import com.niit.project.restaurantservice.exception.CuisineAlreadyExistException;
import com.niit.project.restaurantservice.model.Cuisine;
import com.niit.project.restaurantservice.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuisineServiceImpl implements CuisineService
{
    private CuisineRepository cuisineRepository;

    @Autowired
    public CuisineServiceImpl(CuisineRepository cuisineRepository)
    {
        this.cuisineRepository = cuisineRepository;
    }

    @Override
    public Cuisine addCuisine(Cuisine cuisine) throws CuisineAlreadyExistException {
        if(cuisineRepository.findById(cuisine.getCuisineName()).isEmpty())
        {
            return cuisineRepository.save(cuisine);
        }
        else
        {
            throw new CuisineAlreadyExistException();
        }
    }

    @Override
    public List<Cuisine> getAllCuisine() {
        return cuisineRepository.findAll();
    }
}
