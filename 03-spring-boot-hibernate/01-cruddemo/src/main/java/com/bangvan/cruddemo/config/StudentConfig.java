package com.bangvan.cruddemo.config;


import com.bangvan.cruddemo.dao.StudentDAO;
import com.bangvan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return args -> {
            System.out.println(studentDAO.multiDelete("Nguyen Thanh Hoa"));
        };
    }
}
