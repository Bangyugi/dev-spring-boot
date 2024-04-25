package com.bangvan.cruddemo.dao;

import com.bangvan.cruddemo.entity.Student;
import jakarta.transaction.Transactional;

import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student findById(Long id);

    public List<Student> findByName(String name);

    public void update(Student student);

    public Integer multiUpdate(String name1, String name2);

    public void delete(Long id);

    public Integer multiDelete(String name);

}
