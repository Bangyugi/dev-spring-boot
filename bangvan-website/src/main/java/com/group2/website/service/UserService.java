package com.group2.website.service;

import com.group2.website.entity.User;
import com.group2.website.objects.UserDTO;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public interface UserService {
    public Optional<User> findUserByEmail(String email);
    public Optional<User> findUserByUsername(String username);
    public boolean usernameExists(String username);
    public boolean userEmailExists(String email);
    public User save (User user);
    public User register(UserDTO userDTO) throws NoSuchAlgorithmException;

    public String encryptPassword(String originalPassword) throws NoSuchAlgorithmException;

    public boolean userInvalid(String username, String password) throws NoSuchAlgorithmException;
}
