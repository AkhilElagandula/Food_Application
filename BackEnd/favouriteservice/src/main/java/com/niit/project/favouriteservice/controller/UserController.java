package com.niit.project.favouriteservice.controller;

import com.niit.project.favouriteservice.model.User;
import com.niit.project.favouriteservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin("*")
@RestController
@RequestMapping("/foodieApp/userService")
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }
}
