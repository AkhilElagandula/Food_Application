package com.niit.project.favouriteservice.service;

import com.netflix.discovery.converters.Auto;
import com.niit.project.favouriteservice.model.User;
import com.niit.project.favouriteservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
