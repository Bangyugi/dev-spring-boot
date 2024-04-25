package com.bangvan.springbootdemo.configuration;

import com.bangvan.springbootdemo.model.Student;
import com.bangvan.springbootdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Configuration
public class StudentConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository)
//    {
//        return args -> {
////            Student hoang = new Student(
////                    "Pham Huy Hoang",
////                    "hoangphamhuy@gmail.com",
////                    LocalDate.of(2004, Month.JULY,25)
////            );
////            Student nam = new Student(
////                    "Dong Binh Nam",
////                    "binhnamdong19@gmail.com",
////                    LocalDate.of(2004, Month.OCTOBER, 16)
////            );
////            Student bang = new Student(
////                    "Tran Van Bang",
////                    "bangtranvan08@gmail.com",
////                    LocalDate.of(2004,Month.AUGUST, 22)
////            );
////            Student kien = new Student(
////                    "Nguyen Duc Kien",
////                    "nguyenduckien123@gmail.com",
////                    LocalDate.of(2002,Month.SEPTEMBER,11)
////            );
////            repository.saveAll(
////                    List.of(hoang,nam,bang,kien)
////            );
//        };
//    }
}
