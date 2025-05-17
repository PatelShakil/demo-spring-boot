package com.springdemo.demo.repositories.impl;

import com.springdemo.demo.models.User;
import com.springdemo.demo.repositories.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    JdbcTemplate jdbc;

    public UserRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int addUser(String uid,User user) {
        String sql = "Insert into user_java(username,_id) values ('" + user.getUsername() + "','" + uid + "');";
        return jdbc.update(sql);
    }
}
