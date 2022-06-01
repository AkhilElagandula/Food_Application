package com.niit.project.user.service;

import com.niit.project.user.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String,String> generateToken(User user);
}
