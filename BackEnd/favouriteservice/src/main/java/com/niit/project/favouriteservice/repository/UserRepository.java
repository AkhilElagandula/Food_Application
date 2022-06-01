package com.niit.project.favouriteservice.repository;

import com.niit.project.favouriteservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String>
{

}