package com.niit.project.restaurantservice.repository;

import com.niit.project.restaurantservice.model.Cuisine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends MongoRepository<Cuisine,String>
{

}
