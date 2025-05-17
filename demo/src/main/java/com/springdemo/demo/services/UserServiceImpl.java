package com.springdemo.demo.services;

import com.springdemo.demo.models.User;
import com.springdemo.demo.models.UserResponse;
import com.springdemo.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public boolean validateUser(User user) {
        return user.getUsername() != null && !user.getUsername().isEmpty();
    }

    @Override
    public Optional<UserResponse> addUser(User user) {
        String uid = UUID.randomUUID().toString();
        int result = userRepository.addUser(uid,user);
        if(result > 0){
            return Optional.of(new UserResponse(user.getUsername(),uid));
        }
        return Optional.empty();
    }
}
