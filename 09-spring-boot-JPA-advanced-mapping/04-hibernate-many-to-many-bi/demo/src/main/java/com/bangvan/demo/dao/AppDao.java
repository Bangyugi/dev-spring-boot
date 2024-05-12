package com.bangvan.demo.dao;

import com.bangvan.demo.entity.Course;
import com.bangvan.demo.entity.Student;
import jakarta.transaction.Transactional;

public interface AppDao {
    void createStudentWithCourse(Student student);

    void createCourseWithStudent(Course course);

    Student findStudentWithCourseById(int id);

    Course findCourseWithStudentById(int id);

    void updateStudent(Student tempStudent);

    void deleteStudentById(int id);

    void deleteCourseByID(int id);


}
