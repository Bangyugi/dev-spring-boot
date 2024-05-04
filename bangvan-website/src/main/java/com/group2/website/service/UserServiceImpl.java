package com.group2.website.service;

import com.group2.website.entity.Authority;
import com.group2.website.entity.User;
import com.group2.website.objects.UserDTO;
import com.group2.website.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.mapper.Mapper;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    // find user by email
    @Transactional
    public Optional<User> findUserByEmail(String email){
        return  userRepository.findUserByEmail(email);
    }


    // find user by username
    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    // check if user's email  exist
    public boolean userEmailExists(String email){
        return findUserByEmail(email).isPresent();
    }

    // check if user's username exist
    public boolean usernameExists(String username){
        return findUserByUsername(username).isPresent();
    }
    // save user
    @Transactional
    public User save (User user){
        return userRepository.save(user);
    }

    // get user from userDTO
    public User register(UserDTO userDTO) throws NoSuchAlgorithmException {
        //password encryption
        String encryptPass = encryptPassword(userDTO.getPassword());
        System.out.println(encryptPass);
        User user = new User(userDTO.getUsername(),encryptPass,userDTO.getEmail(),(byte)1);
        System.out.println(user);
        Authority authority = new Authority("ROLE_EMPLOYEE");
        user.add(authority);
        return save(user);
    }
    @Override
    public String encryptPassword(String originalPassword) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(
                originalPassword.getBytes(StandardCharsets.UTF_8));
        String sha256hex = new String(Hex.encode(hash));
        return sha256hex;
    }

    @Override
    public boolean userInvalid(String username, String password) throws NoSuchAlgorithmException {
        if(usernameExists(username))
        {
            User user = userRepository.findUserByUsername(username).get();
            password = encryptPassword(password);
            System.out.println(password);
            if (password.equals(user.getPassword()))
            {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return true;
        }
    }


}
