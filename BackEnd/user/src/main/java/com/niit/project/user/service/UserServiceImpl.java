package com.niit.project.user.service;

import com.niit.project.user.exception.UserAlreadyExistException;
import com.niit.project.user.exception.UserNotFoundException;
import com.niit.project.user.model.User;
import com.niit.project.user.proxy.UserProxy;
import com.niit.project.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserProxy userProxy){
        this.userRepository=userRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if(userRepository.findById(user.getEmailId()).isEmpty()) {
            //inserts record into mysql
            User result = userRepository.save(user);

            user.setPassword("");
            user.setConfirmPassword("");
            //calling favouriteService addUser() , inserts records into favouriteService also
            ResponseEntity response = userProxy.addUser(user);

            System.out.println("Response : "+response.getBody());
            return result;
        }
        else {
            throw new UserAlreadyExistException();
        }
    }

    public User authenticationUser( String emailId,String password) throws UserNotFoundException
    {
        User user=userRepository.findByEmailIdAndPassword(emailId,password);
        if(user!=null)
        {
            return user;
        }
        else
        {
            throw new UserNotFoundException();
        }
    }
}
