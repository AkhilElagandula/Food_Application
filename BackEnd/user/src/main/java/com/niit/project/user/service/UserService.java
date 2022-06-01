package com.niit.project.user.service;

import com.niit.project.user.exception.UserAlreadyExistException;
import com.niit.project.user.exception.UserNotFoundException;
import com.niit.project.user.model.User;

import java.util.List;

public interface UserService {

    public abstract User addUser(User user) throws UserAlreadyExistException;

    public abstract User authenticationUser(String emailId,String password) throws UserNotFoundException;

}
