package com.springdemo.demo.services;

import com.springdemo.demo.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean validateUser(User user) {
        return user.getUsername() != null && !user.getUsername().isEmpty();
    }
}
