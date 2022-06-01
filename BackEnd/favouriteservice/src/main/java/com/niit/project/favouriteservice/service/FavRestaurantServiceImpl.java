package com.niit.project.favouriteservice.service;


import com.niit.project.favouriteservice.exception.RestaurantAlreadyExistException;
import com.niit.project.favouriteservice.model.FavouriteRestaurant;
import com.niit.project.favouriteservice.repository.FavRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavRestaurantServiceImpl implements FavRestaurantService
{
    private FavRestaurantRepository favRestaurantRepository;

    @Autowired
    public FavRestaurantServiceImpl(FavRestaurantRepository favRestaurantRepository)
    {
        this.favRestaurantRepository = favRestaurantRepository;
    }

    @Override
    public FavouriteRestaurant addFavRestaurant(FavouriteRestaurant favouriteRestaurant) throws RestaurantAlreadyExistException {

        FavouriteRestaurant result = (favRestaurantRepository.findByEmailIdAndRestaurantName(favouriteRestaurant.getEmailId(),favouriteRestaurant.getRestaurantName()));
        if(result==null)
        {
            return favRestaurantRepository.save(favouriteRestaurant);
        }
        else
        {
            throw new RestaurantAlreadyExistException();
        }
    }

    @Override
    public List<FavouriteRestaurant> getAllFavRestaurant() {
        return favRestaurantRepository.findAll();
    }

    @Override
    public boolean deleteByRestaurantId(long restaurantId) {
        favRestaurantRepository.deleteById(restaurantId);
        return true;
    }

    @Override
    public List<FavouriteRestaurant> getAllFavRestaurantByEmailId(String emailId) {
        return favRestaurantRepository.findAllByEmailId(emailId);
    }

    @Override
    public boolean deleteFavRestaurantByEmailIdAndRestaurantName(String emailId, String restaurantName) {
        favRestaurantRepository.deleteByEmailIdAndRestaurantName(emailId,restaurantName);
        return true;
    }


}
