package com.bangvan.service;

import com.bangvan.model.User;

import java.util.List;

public interface UserService {
    public User findByUsername(String name);
    public List<User> findAllUser();
    public void saveUser(User user);
}
