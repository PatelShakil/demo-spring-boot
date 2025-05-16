package com.springdemo.demo.controllers;

import com.springdemo.demo.models.User;
import com.springdemo.demo.models.UserResponse;
import com.springdemo.demo.services.UserService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // method 1 : RequestMapping annotation
//    @RequestMapping(method = RequestMethod.POST)
//    @RequestMapping(value="add",method = RequestMethod.POST)
    //method 2 : directly short annotations

//    @Autowired
//    private UserService userService;

    private UserService userService;

    // DI
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse addUsers(@RequestBody User user){

        boolean result = userService.validateUser(user);
        if(result){
            return new UserResponse(user.getUsername(), UUID.randomUUID().toString());
        }
        return new UserResponse(user.getUsername(), UUID.randomUUID().toString());
    }
}
