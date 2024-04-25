package com.bangvan.controller;

import com.bangvan.models.Employee;
import com.bangvan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employeeForm")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new-employee-page";
    }

    @PostMapping("/processEmployee")
    public String processEmployee(@ModelAttribute("employee")Employee employee,Model model){
        System.out.println(employee);
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String allEmployees(Model model){
        List<Employee> employees = employeeService.findAllEmployee();
        model.addAttribute("employees", employees);
        return "employee-informations";
    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employees";
    }
}
