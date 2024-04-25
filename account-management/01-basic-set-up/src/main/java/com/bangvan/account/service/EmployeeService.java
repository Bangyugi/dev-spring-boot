package com.bangvan.account.service;

import com.bangvan.account.models.Employee;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);
    public List<Employee> findAllEmployee();
    public void deleteEmployee(Integer id);
    public  Employee findById(Integer id);
}
