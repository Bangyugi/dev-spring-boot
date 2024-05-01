package com.bangvan.cruddemo.dao;

import com.bangvan.cruddemo.entity.Instructor;
import com.bangvan.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save (Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorByID(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
