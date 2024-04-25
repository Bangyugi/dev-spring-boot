package com.bangvan.Demo.controller;

import com.bangvan.Demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @GetMapping("/students")
    public List<Student> getStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bang", "Tran"));
        students.add(new Student("Neil","Phelan"));
        students.add(new Student("Quimory","Tran"));
        return students;
    }
}
