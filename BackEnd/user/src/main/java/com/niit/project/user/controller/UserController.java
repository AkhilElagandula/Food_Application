package com.niit.project.user.controller;

import com.niit.project.user.exception.PasswordDoesNotMatchException;
import com.niit.project.user.exception.UserAlreadyExistException;
import com.niit.project.user.exception.UserNotFoundException;
import com.niit.project.user.model.User;
import com.niit.project.user.service.SecurityTokenGenerator;
import com.niit.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/foodieApp/user")
public class UserController {

    private UserService userService;

    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService,SecurityTokenGenerator securityTokenGenerator){
        this.userService=userService;
        this.securityTokenGenerator=securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistException , PasswordDoesNotMatchException
    {
        try {
            if (user.getPassword().equals(user.getConfirmPassword())) {
                return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
            }
            else {
                throw new PasswordDoesNotMatchException();
            }
        }
        catch (UserAlreadyExistException uae)
        {
            throw new UserAlreadyExistException();
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody User user) throws UserNotFoundException {
        Map<String, String> map=null;

        try{
            User resultuser = userService.authenticationUser(user.getEmailId(),user.getPassword());

            if(resultuser!=null ){

                map=securityTokenGenerator.generateToken(resultuser);
                map.put("user",resultuser.getFullName());
                map.put("role",resultuser.getRole());

            }
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        catch (UserNotFoundException ue){
            throw new UserNotFoundException();

        }
        catch(Exception e){
            return new ResponseEntity<>("other Exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
