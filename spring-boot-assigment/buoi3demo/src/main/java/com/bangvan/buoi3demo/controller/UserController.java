package com.bangvan.buoi3demo.controller;

import com.bangvan.buoi3demo.exception.NotFound;
import com.bangvan.buoi3demo.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class UserController {
    private List<User> users;

    @PostConstruct
    public void generateUser(){
        users = IntStream.range(0,10)
                .mapToObj(i->new User(i,"username"+i, "password"+i))
                .collect(Collectors.toList());
    }

    @GetMapping("/users/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/users/getUser/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        for(User user: users){
            if (user.getId() == id){
                return ResponseEntity.ok().body(user);
            }
        }
        throw new NotFound("khong tim thay");
    }

    @PostMapping("/user/createUser")
    public String createUser(@RequestBody User user){
        users.add(user);
        return "Creating new user ...\n Successful" ;
    }

    @DeleteMapping("/users/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        users.remove(id);
        return ResponseEntity.ok().body(users);
    }


}
