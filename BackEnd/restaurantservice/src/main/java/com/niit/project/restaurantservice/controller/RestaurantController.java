package com.niit.project.restaurantservice.controller;

import com.niit.project.restaurantservice.exception.RestaurantAlreadyExistException;
import com.niit.project.restaurantservice.exception.RestaurantNotFoundException;
import com.niit.project.restaurantservice.model.Restaurant;
import com.niit.project.restaurantservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/foodieApp/restaurant")
public class RestaurantController
{
    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService)
    {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) throws RestaurantAlreadyExistException {
        try
        {
            return new ResponseEntity<>(restaurantService.addRestaurant(restaurant), HttpStatus.OK);
        }
        catch (RestaurantAlreadyExistException rae)
        {
            throw new RestaurantAlreadyExistException();
        }
    }

    @PutMapping("updateRestaurant")
    public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant)
    {
        return new ResponseEntity<>(restaurantService.updateRestaurant(restaurant),HttpStatus.OK);
    }

    @GetMapping("/getRestaurant")
    public ResponseEntity<?> getAllRestaurants()
    {
        return new ResponseEntity<>(restaurantService.getAllRestaurants(),HttpStatus.OK);
    }

    @GetMapping("/restaurant-by-location/{location}")
    public ResponseEntity<?> getRestaurantByLocation(@PathVariable String location) throws RestaurantNotFoundException
    {
        return new ResponseEntity<>(restaurantService.getRestaurantByLocation(location),HttpStatus.OK);
    }

    @GetMapping("/restaurant-by-cuisineName/{cuisineName}")
    public ResponseEntity<?> getRestaurantByCuisine(@PathVariable String cuisineName) throws RestaurantNotFoundException
    {
        return new ResponseEntity<>(restaurantService.getRestaurantByCuisineName(cuisineName),HttpStatus.OK);
    }

    @GetMapping("/restaurant-by-restaurantName/{restaurantName}")
    public ResponseEntity<?> getRestaurantByRestaurant(@PathVariable String restaurantName) throws RestaurantNotFoundException
    {
        return new ResponseEntity<>(restaurantService.getRestaurantByRestaurantName(restaurantName),HttpStatus.OK);
    }

    @GetMapping("/restaurant-byLocationAndCuisine/{location}/{cuisineName}")
    public ResponseEntity<?> getRestaurantByLocationAndCuisineName(@PathVariable String location,@PathVariable String cuisineName) throws RestaurantNotFoundException
    {
        return new ResponseEntity<>(restaurantService.getRestaurantByLocationAndCuisineName(location,cuisineName),HttpStatus.OK);
    }

    @GetMapping("/restaurant-by/{location}/{restaurantName}")
    public ResponseEntity<?> getRestaurantByLocationAndRestaurantName(@PathVariable String restaurantName,@PathVariable String location) throws RestaurantNotFoundException
    {
        return new ResponseEntity<>(restaurantService.getRestaurantByLocationAndRestaurantName(location,restaurantName),HttpStatus.OK);
    }
}
