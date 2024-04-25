package com.bangvan.project.service;

import com.bangvan.project.error.EmployeeNotFoundException;
import com.bangvan.project.models.Employee;
import com.bangvan.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplement(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findALl(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.orElseThrow(() -> new EmployeeNotFoundException("Employee not found! - "+id));

    }

    public String save(Employee employee){
        employeeRepository.save(employee);
        return "Add an employee successfully!";
    }

    public String deleteById(Long id){
        employeeRepository.deleteById(id);
        return "Delete an employee succesfully!";
    }

}
