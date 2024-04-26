package com.bangvan.controler;

import com.bangvan.model.User;
import com.bangvan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "login-form";
    }

    @GetMapping("/information")
    public String showUserForm(Model model){
        model.addAttribute("user",new User());
        return "user-information-form";
    }

    @PostMapping("/information")
    public String informationUser(@ModelAttribute("user")User user){
        System.out.println(user);
        userService.saveUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user",new User());
        return "register-form";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user")User user){
        if (user.getPassword().equals(user.getConfirmPassword())) {
            return "user-information-form";
        }
        else {
            return "redirect:/user/register";
        }
    }


    @PostMapping("/list")
    public String processLoginUser(@ModelAttribute("user") User user,Model model){
        System.out.println(user);
        User theUser = userService.findByUsername(user.getUsername());
        if (theUser!=null && user.getPassword().equals(theUser.getPassword()))
        {
            List<User> users = userService.findAllUser();
            model.addAttribute("users",users);
            return "user-list";
        }
        else {
            return "redirect:/user/login";
        }
    }
}
