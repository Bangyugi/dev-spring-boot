package com.bangvan.project.controller;

import com.bangvan.project.dao.EmployeeDAO;
import com.bangvan.project.dao.EmployeeDAOImplement;
import com.bangvan.project.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeDAO service;
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee)
    {
        service.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmpoyeeById(@PathVariable Long employeeId){
        return service.getEmployeeByID(employeeId);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee){
        service.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void removeEmployee(@PathVariable Long employeeId){
        service.deleteEmployee(employeeId);
    }
}
