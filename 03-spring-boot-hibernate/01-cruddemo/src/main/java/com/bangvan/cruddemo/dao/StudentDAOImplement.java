package com.bangvan.cruddemo.dao;

import com.bangvan.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImplement implements StudentDAO{


    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //inject entity manager using constructor injection
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> typedQuery = entityManager.createQuery(
                "FROM Student WHERE name = :theData", Student.class);
        typedQuery.setParameter("theData",name);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public Integer multiUpdate(String name1, String name2) {
        Query updateQuery= entityManager.createQuery(
                "UPDATE Student SET name = :theData1 WHERE name = :theData2");
        updateQuery.setParameter("theData1", name1);
        updateQuery.setParameter("theData2",name2);
        int numRowsUpdate = updateQuery.executeUpdate();
        return numRowsUpdate;

    }

    @Override
    @Transactional
    public void delete(Long id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Integer multiDelete(String name) {
        Query query = entityManager.createQuery("DELETE Student WHERE name = :theData");
        query.setParameter("theData",name);
        Integer numRowUpdate = query.executeUpdate();
        return numRowUpdate;
    }


}
