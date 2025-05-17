package com.springdemo.demo.controllers;

import com.springdemo.demo.models.User;
import com.springdemo.demo.models.UserResponse;
import com.springdemo.demo.services.UserService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // method 1: RequestMapping annotation
//    @RequestMapping(method = RequestMethod.POST)
//    @RequestMapping(value="add",method = RequestMethod.POST)
    //method 2: directly short annotations

//    @Autowired
//    private UserService userService;

    private final UserService userService;

    // DI
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity addUsers(@RequestBody User user) {

        boolean result = userService.validateUser(user);
        if (result) {
            Optional<UserResponse> resp = (userService.addUser(user));
            return resp.isPresent() ? ResponseEntity.ok(resp.get()) : ResponseEntity.internalServerError().body("Internal Server Error");
        }
        return ResponseEntity.badRequest().body("Bad Request");
    }

    @PostMapping(value = "/{_id}/exercise")
    public ResponseEntity addExercise(@PathVariable("_id") int _id,@RequestBody Map<String,String> exercise) {
        exercise.put("_id",_id+"");
        return ResponseEntity.ok(exercise);
    }

}
