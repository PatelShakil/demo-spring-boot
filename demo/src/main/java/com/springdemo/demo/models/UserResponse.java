package com.springdemo.demo.models;

public class UserResponse {
    String username;
    String _id;

    public UserResponse(String username, String _id) {
        this.username = username;
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "username:'" + username + '\'' +
                ", _id:'" + _id + '\'' +
                '}';
    }
}
