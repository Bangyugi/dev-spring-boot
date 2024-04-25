package com.bangvan.project.dao;

import com.bangvan.project.error.EmployeeNotFoundException;
import com.bangvan.project.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAOImplement implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        Query query = entityManager.createQuery("FROM Employee");
        return query.getResultList();
    }

    @Override
    public Employee getEmployeeByID(Long id) {
        Employee employee = entityManager.find(Employee.class,id);
        return Optional.ofNullable(employee).orElseThrow(() -> new EmployeeNotFoundException("Employee not found - " + id));
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }


}
