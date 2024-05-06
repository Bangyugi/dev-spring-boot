package com.group2.website.controller;

import com.group2.website.entity.User;
import com.group2.website.objects.UserDTO;
import com.group2.website.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.NoSuchAlgorithmException;

@Controller
public class AccountController {

    private final UserService userService;


    @Autowired
    public AccountController(UserService userService, HttpSession httpSession) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String register(@ModelAttribute UserDTO userDTO, Model model)
    {
        model.addAttribute("userDTO", userDTO);
        return "register-page";
    }
    @PostMapping("/register")
    public String accountSave(@Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws NoSuchAlgorithmException {

        //check if the user's username exist
        if(userService.usernameExists(userDTO.getUsername()))
        {
            bindingResult.addError(new FieldError("userDTO","username","Username already in use"));
        }

        //check if the user's email exist
        if (userService.userEmailExists(userDTO.getEmail()))
        {
            bindingResult.addError(new FieldError("userDTO","email","Email address already in use"));
        }

        //check if the password match
        if(userDTO.getPassword()!=null && userDTO.getRpassword()!=null){
            if (!userDTO.getPassword().equals(userDTO.getRpassword())){
                bindingResult.addError(new FieldError("userDTO", "rpassword", "Re-password does not match"));
            }
        }

        if(bindingResult.hasErrors()){
            return "register-page";
        }
        System.out.println(userDTO);
        redirectAttributes.addFlashAttribute("message","Success! your registration is now complete");
        userService.register(userDTO);
        return "redirect:/login";

    }

    @GetMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO",userDTO);
        return "login-page";
    }
    @PostMapping("/home")
    public String process(UserDTO userDTO, Model model) throws NoSuchAlgorithmException {


        if (userDTO.getUsername()==null || userDTO.getPassword() ==null)
        {
            model.addAttribute("message","Please! enter your username and password");
            return "login-page";
        }
        if (userService.userInvalid(userDTO.getUsername(),userDTO.getPassword())){
            model.addAttribute("message","Oops! wrong username or password");
            return "login-page";
        }
        User user = userService.findUserByUsername(userDTO.getUsername()).get();
        System.out.println(user);
        model.addAttribute("user", user);
        return "home-page";
    }

    @GetMapping("/home")
    public String home(UserDTO userDTO)
    {
        return "home-page";
    }
}
