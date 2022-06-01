package com.niit.project.user.proxy;

import com.niit.project.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="favourite-service", url = "localhost:7070")
public interface UserProxy
{
    @PostMapping("/foodieApp/userService/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user);
}