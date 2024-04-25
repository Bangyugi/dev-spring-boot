package com.bangvan.springbootdemo.service;

import com.bangvan.springbootdemo.model.Student;
import com.bangvan.springbootdemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student){
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
        {
            throw new IllegalStateException("email was taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        boolean exist = studentRepository.existsById(studentId);
        if(!exist)
        {
            throw new IllegalStateException(
                    "student with id "+ studentId + " does not exists"
            );
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String studentName, String studentEmail){
        boolean exist = studentRepository.existsById(studentId);
        Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("student with id "+ studentId + " does not exists"));
        if (studentName != null && studentName.length()>0 && !Objects.equals(student.getName(),studentName)){
            student.setName(studentName);

        }
        if (studentEmail != null && studentEmail.length()>0 && !Objects.equals(student.getEmail(),studentEmail)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentEmail);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email was taken");
            }
            student.setEmail(studentEmail);
        }
    }
}
