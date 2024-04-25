package com.bangvan.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/showForm")
    public String showForm (){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");
        String result = "Yo! " + name.toUpperCase() + " Good to see you here!";
        model.addAttribute("message",result);
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String goodMorning(@RequestParam("studentName") String name, Model model){
        String result = "Good morning " + name +"!";
        model.addAttribute("message",result);
        return "helloworld";
    }

}
