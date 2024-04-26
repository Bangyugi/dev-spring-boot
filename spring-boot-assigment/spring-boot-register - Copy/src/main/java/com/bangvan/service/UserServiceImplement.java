package com.bangvan.service;

import com.bangvan.model.User;
import com.bangvan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String name) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(name));
        if(user.isPresent())
        {
            return user.get();
        }
        else {
            return null;
        }

    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
