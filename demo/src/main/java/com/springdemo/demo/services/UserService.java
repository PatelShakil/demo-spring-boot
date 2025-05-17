package com.springdemo.demo.services;

import com.springdemo.demo.models.User;
import com.springdemo.demo.models.UserResponse;

import java.util.Optional;

public interface UserService {

    boolean validateUser(User user);

    Optional<UserResponse> addUser(User user);
}
