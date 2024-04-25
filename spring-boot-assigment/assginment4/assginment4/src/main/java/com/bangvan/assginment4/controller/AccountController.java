package com.bangvan.assginment4.controller;

import com.bangvan.assginment4.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {

    private List<User> users;

    @PostConstruct
    public void dummyData(){
        users = new ArrayList<>();
        users.add(new User(100,"BangVan","bangtranvandeptrai"));
        users.add(new User(101,"binhnamdong95","namnamnam"));
        users.add(new User(102,"kienpro","?password?"));
        users.add(new User(103,"neilphelan85","neil85"));
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById (@PathVariable int userId){
        User user = null;
        for (User x: users){
            if(x.getId() == userId){
                user = x;
                break;
            }
        }
        return user;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUserById(@PathVariable int userId)
    {
        for (User user: users){
            if (user.getId()==userId){
                users.remove(user);
                return "Remove successful!";
            }
        }
        return "Remove failed!";
    }

    @PostMapping("/users")
    public String postUser(@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword){
        if (password.equals(confirmPassword)){
            User user = new User(username,password);
            users.add(user);
            return "user Added";
        }
        return "Add user failed";

    }

}
