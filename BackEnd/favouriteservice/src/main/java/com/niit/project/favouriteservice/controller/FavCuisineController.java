package com.niit.project.favouriteservice.controller;

import com.niit.project.favouriteservice.exception.CuisineAlreadyExistException;
import com.niit.project.favouriteservice.model.FavouriteCuisine;
import com.niit.project.favouriteservice.service.FavCuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//@CrossOrigin("*")
@RestController
@RequestMapping("/foodieApp/favourites")
public class FavCuisineController
{
    private FavCuisineService favCuisineService;

    @Autowired
    public FavCuisineController(FavCuisineService favCuisineService)
    {
        this.favCuisineService = favCuisineService;
    }

    @PostMapping("/addFavCuisine")
    public ResponseEntity<?> addFavCuisine(@RequestBody FavouriteCuisine favouriteCuisine) throws CuisineAlreadyExistException {
        try
        {
            return new ResponseEntity<>(favCuisineService.addFavCuisine(favouriteCuisine), HttpStatus.OK);
        }
        catch (CuisineAlreadyExistException cae)
        {
            throw new CuisineAlreadyExistException();
        }
    }

    @GetMapping("/favCuisineByEmailId/{emailId}")
    public ResponseEntity<?> getAllCuisineByEmailId(@PathVariable String emailId)
    {
        return new ResponseEntity<>(favCuisineService.getAllFavCuisineByEmailId(emailId),HttpStatus.OK);
    }

    @GetMapping("/favCuisine")
    public ResponseEntity<?> getAllFavCuisine()
    {
        return new ResponseEntity<>(favCuisineService.getAllCuisine(),HttpStatus.OK);
    }

    @DeleteMapping("/favCuisine/{cuisineId}")
    public ResponseEntity<?> deleteFavCuisine(@PathVariable Long cuisineId){

        favCuisineService.deleteByCuisineId(cuisineId);
        return new ResponseEntity<>("",HttpStatus.OK);
    }
}
