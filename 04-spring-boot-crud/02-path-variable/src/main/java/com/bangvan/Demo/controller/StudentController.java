package com.bangvan.Demo.controller;

import com.bangvan.Demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> studentList;

    @PostConstruct
    public void loadData(){
        studentList = new ArrayList<>();
        studentList.add(new Student(1,"Neil", "Phelan"));
        studentList.add(new Student(2,"Mario","Rossi"));
        studentList.add(new Student(3,"Mary","Smith"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentList;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        Optional<Student> studentOptional = studentList.stream().filter(x->x.getId()==id).findFirst();
        if (studentOptional.isPresent())
        {
            return ResponseEntity.ok(studentOptional.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
