package com.bangvan.service;

import com.bangvan.models.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public List<Employee> findAllEmployee();
    public void deleteEmployee(Integer id);
    public  Employee findById(Integer id);
}
