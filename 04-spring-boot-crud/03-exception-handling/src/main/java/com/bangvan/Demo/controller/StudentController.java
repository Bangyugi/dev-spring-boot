package com.bangvan.Demo.controller;

import com.bangvan.Demo.entity.Student;
import com.bangvan.Demo.error.StudentErrorResponse;
import com.bangvan.Demo.error.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Student getStudent(@PathVariable int id){
        boolean check = false;
        Student res = null;
        for (Student student: studentList){
            if (student.getId() == id){
                res = student;
                check = true;
                break;
            }
        }
        if (!check)
        {
            throw new StudentNotFoundException("Student id not found - "+id);
        }
        return res;
    }


}
