package com.bangvan.demo.dao;

import com.bangvan.demo.entity.Course;
import com.bangvan.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImplement implements AppDao{
    private final EntityManager entityManager;

    public AppDaoImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createStudentWithCourse(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void createCourseWithStudent(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Student findStudentWithCourseById(int id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s JOIN FETCH s.courses where s.id=:data", Student.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseWithStudentById(int id){
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.students where c.id =:data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);

    }



    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteCourseByID(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }


}
