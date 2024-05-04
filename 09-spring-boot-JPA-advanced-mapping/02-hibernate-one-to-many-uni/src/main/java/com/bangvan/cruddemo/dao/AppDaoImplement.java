package com.bangvan.cruddemo.dao;

import com.bangvan.cruddemo.entity.Course;
import com.bangvan.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImplement implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void createInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorByID(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        // create Query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data",id);
        // execute Query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select I from Instructor I JOIN FETCH I.instructorDetail JOIN FETCH I.courses where I.id = :data",
                Instructor.class
        );
        query.setParameter("data",id);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        Course course = entityManager.find(Course.class,id);
        return course;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        // retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);
        List<Course> courses = instructor.getCourses();
        // break associations of all course for instructor
        for(Course course:courses){
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

}
