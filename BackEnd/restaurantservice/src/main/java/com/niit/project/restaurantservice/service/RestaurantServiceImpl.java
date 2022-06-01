package com.niit.project.restaurantservice.service;

import com.niit.project.restaurantservice.exception.RestaurantAlreadyExistException;
import com.niit.project.restaurantservice.exception.RestaurantNotFoundException;
import com.niit.project.restaurantservice.model.Cuisine;
import com.niit.project.restaurantservice.model.Restaurant;
import com.niit.project.restaurantservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository)
    {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException {
        if(restaurantRepository.findById(restaurant.getRestaurantId()).isEmpty())
        {
            return restaurantRepository.save(restaurant);
        }
        else
        {
            throw new RestaurantAlreadyExistException();
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantByLocation(String location) throws RestaurantNotFoundException {
        return restaurantRepository.findByLocation(location);
    }

    @Override
    public List<Restaurant> getRestaurantByCuisineName(String cuisineName) throws RestaurantNotFoundException {
        return restaurantRepository.findByCuisineName(cuisineName);
    }

    @Override
    public List<Restaurant> getRestaurantByRestaurantName(String restaurantName) throws RestaurantNotFoundException {
        return restaurantRepository.findByRestaurantName(restaurantName);
    }


    @Override
    public List<Restaurant> getRestaurantByLocationAndCuisineName(String location, String cuisineName) throws RestaurantNotFoundException {
        // get rest by location : res1
        // get rest by cuisine in res1
//         List<Restaurant> result1 = restaurantRepository.findByLocation(location);
//         System.out.println(result1);
//        List<Restaurant> result2 =new ArrayList<Restaurant>();
//        for(Restaurant r : result1){
//            for(Cuisine c: r.getCuisine()){
//                if(c.getCuisineName().equalsIgnoreCase(cuisineName)){
//                    result2.add(r);
//                }
//            }
//        }
//      //List<Restaurant> cuisines = result1.stream()
//        //      .filter(c->c.getCuisine().
//                        //                .collect(Collectors.toList());
////        System.out.println(cuisines);
//       return result2;
        return restaurantRepository.findByLocationAndCuisineName(location,cuisineName);
    }

    @Override
    public List<Restaurant> getRestaurantByLocationAndRestaurantName(String location, String restaurantName) throws RestaurantNotFoundException {
        return restaurantRepository.findByLocationAndRestaurantName(location,restaurantName);
    }


    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }


}
