package com.bangvan.project.controller;

import com.bangvan.project.models.Employee;
import com.bangvan.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee)
    {
        return service.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return service.findALl();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmpoyeeById(@PathVariable Long employeeId){
        return service.findById(employeeId);
    }

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee employee){
        return service.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String removeEmployee(@PathVariable Long employeeId){
        return service.deleteById(employeeId);
    }
}
