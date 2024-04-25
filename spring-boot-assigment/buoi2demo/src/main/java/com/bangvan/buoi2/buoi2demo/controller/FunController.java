package com.bangvan.buoi2.buoi2demo.controller;

import com.bangvan.buoi2.buoi2demo.Phone;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FunController {
    private List<Phone> list = new ArrayList<>();
    @GetMapping("/index")
    public String index (){
        return "index";
    }

    @PostMapping("/index")
    public void addPhone (@RequestParam String name){
        list.add(new Phone(name));
    }

    @GetMapping("/about")
    public String listPhone(Model model){
        model.addAttribute("list",list);
        return "about";
    }

    @GetMapping("/data")
    public ResponseEntity<List<Phone>>data(){
        return ResponseEntity.ok().body(list);
    }


}
