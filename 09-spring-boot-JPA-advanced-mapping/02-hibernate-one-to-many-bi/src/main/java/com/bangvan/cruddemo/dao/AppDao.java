package com.bangvan.cruddemo.dao;

import com.bangvan.cruddemo.entity.Course;
import com.bangvan.cruddemo.entity.Instructor;

import java.util.List;

public interface AppDao {
    void createInstructor(Instructor instructor);
    Instructor findInstructorByID(int id);

    List<Course> findCourseByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int id);

    void deleteInstructorById(int id);

    void deleteCourseById(int id);
}
