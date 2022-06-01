package com.niit.project.favouriteservice.service;

import com.niit.project.favouriteservice.exception.CuisineAlreadyExistException;
import com.niit.project.favouriteservice.model.FavouriteCuisine;
import com.niit.project.favouriteservice.repository.FavCuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavCuisineServiceImpl implements FavCuisineService
{
    private FavCuisineRepository favCuisineRepository;

    @Autowired
    public FavCuisineServiceImpl(FavCuisineRepository favCuisineRepository)
    {
        this.favCuisineRepository = favCuisineRepository;
    }
    @Override
    public FavouriteCuisine addFavCuisine(FavouriteCuisine favouriteCuisine) throws CuisineAlreadyExistException{
        FavouriteCuisine result = (favCuisineRepository.findByEmailIdAndCuisineName(favouriteCuisine.getEmailId(),favouriteCuisine.getCuisineName()));
        if(result==null)
        {
            return favCuisineRepository.save(favouriteCuisine);
        }
        else
        {
            throw new CuisineAlreadyExistException();
        }
    }

    @Override
    public List<FavouriteCuisine> getAllCuisine() {
        return favCuisineRepository.findAll();
    }

    @Override
    public boolean deleteByCuisineId(Long cuisineId) {
        favCuisineRepository.deleteById(cuisineId);
        return true;
    }

    @Override
    public List<FavouriteCuisine> getAllFavCuisineByEmailId(String emailId) {
        return favCuisineRepository.findAllByEmailId(emailId);
    }
}
