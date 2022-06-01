package com.niit.project.user.service;

import com.niit.project.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{

    @Override
    public Map<String, String> generateToken(User user) {

        Date cd = new Date();
        cd.setMinutes(cd.getMinutes()+60);

        System.out.println("\n\nExisting claims: "+ Jwts.claims().values());

        String jwttoken= Jwts.builder()
                .setSubject(user.getFullName())
                .setIssuedAt(new Date())
                .setExpiration(cd)
                .signWith(SignatureAlgorithm.HS256,"foodieAppKey").compact();
        Map<String,String>map=new HashMap<>();
        map.put("token",jwttoken);
        map.put("message","User successfully logged in");
        return map;
    }
}
