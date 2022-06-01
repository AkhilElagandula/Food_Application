package com.niit.project.favouriteservice.controller;

import com.niit.project.favouriteservice.exception.RestaurantAlreadyExistException;
import com.niit.project.favouriteservice.model.FavouriteRestaurant;
import com.niit.project.favouriteservice.service.FavRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//@CrossOrigin("*")
@RestController
@RequestMapping("/foodieApp/favourites")
public class FavRestaurantController
{
    private FavRestaurantService favRestaurantService;

    @Autowired
    public FavRestaurantController(FavRestaurantService favRestaurantService)
    {
        this.favRestaurantService = favRestaurantService;
    }

    @PostMapping("/addFavRestaurant")
    public ResponseEntity<?> addFavRestaurant(@RequestBody FavouriteRestaurant favouriteRestaurant) throws RestaurantAlreadyExistException {
        try
        {
            return new ResponseEntity<>(favRestaurantService.addFavRestaurant(favouriteRestaurant), HttpStatus.OK);
        }
        catch (RestaurantAlreadyExistException rae)
        {
            throw new RestaurantAlreadyExistException();
        }
    }

    @GetMapping("/favRestaurantByEmailId/{emailId}")
    public ResponseEntity<?> getAllRestaurantByEmailId(@PathVariable String emailId)
    {
        return new ResponseEntity<>(favRestaurantService.getAllFavRestaurantByEmailId(emailId),HttpStatus.OK);
    }

    @GetMapping("/favRestaurant")
    public ResponseEntity<?> getAllFavRestaurant()
    {
        return new ResponseEntity<>(favRestaurantService.getAllFavRestaurant(),HttpStatus.OK);
    }

    @DeleteMapping("/delRestaurant/{restaurantId}")
    public ResponseEntity<?> deleteFavRestaurant(@PathVariable long restaurantId){

        favRestaurantService.deleteByRestaurantId(restaurantId);
            return new ResponseEntity<>("",HttpStatus.OK);
    }

    @DeleteMapping("/delRestaurant/{emailId}/{restaurantName}")
    public ResponseEntity<?> deleteFavRestaurantByEmailIdAndRestaurantName(@PathVariable String emailId,@PathVariable String restaurantName){

        favRestaurantService.deleteFavRestaurantByEmailIdAndRestaurantName(emailId, restaurantName);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

}
