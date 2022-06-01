package com.niit.project.restaurantservice.controller;

import com.niit.project.restaurantservice.exception.CuisineAlreadyExistException;
import com.niit.project.restaurantservice.model.Cuisine;
import com.niit.project.restaurantservice.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodieApp/cuisine")
public class CuisineController
{
    private CuisineService cuisineService;

    @Autowired
    public CuisineController(CuisineService cuisineService)
    {
        this.cuisineService = cuisineService;
    }

    @PostMapping("/addCuisine")
    public ResponseEntity<?> addCuisine(@RequestBody Cuisine cuisine) throws CuisineAlreadyExistException {
        try
        {
            return new ResponseEntity<>(cuisineService.addCuisine(cuisine), HttpStatus.OK);
        }
        catch (CuisineAlreadyExistException cae) {
            throw new CuisineAlreadyExistException();
        }
    }

    @GetMapping("/getAllCuisine")
    public ResponseEntity<?> getAllCuisines()
    {
        return new ResponseEntity<>(cuisineService.getAllCuisine(),HttpStatus.OK);
    }
}
