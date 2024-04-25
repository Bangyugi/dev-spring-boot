package com.bangvan.project.dao;

import com.bangvan.project.models.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeDAO {
    public void saveEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeByID(Long id);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(Long id);
}
