package com.springdemo.demo.repositories;

import com.springdemo.demo.models.User;

public interface UserRepository {
    int addUser(String uid,User user);
}
