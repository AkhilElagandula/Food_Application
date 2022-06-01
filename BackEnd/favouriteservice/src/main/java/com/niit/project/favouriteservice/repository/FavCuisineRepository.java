package com.niit.project.favouriteservice.repository;

import com.niit.project.favouriteservice.model.FavouriteCuisine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavCuisineRepository extends MongoRepository<FavouriteCuisine,Long>
{
    public abstract FavouriteCuisine findByEmailIdAndCuisineName(String emailId , String cuisineName);
    public abstract List<FavouriteCuisine> findAllByEmailId(String emailId);
}
