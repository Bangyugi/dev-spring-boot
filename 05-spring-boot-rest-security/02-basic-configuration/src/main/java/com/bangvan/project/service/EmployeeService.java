package com.bangvan.project.service;

import com.bangvan.project.error.EmployeeNotFoundException;
import com.bangvan.project.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> findALl();

    public Employee findById(Long id);

    public String save(Employee employee);

    public String deleteById(Long id);
}
