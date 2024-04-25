package com.bangvan.controller;

import com.bangvan.models.Employee;
import com.bangvan.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/create/form")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new-employee-page";
    }

    @PostMapping("/save")
    public String processEmployee(@Valid @ModelAttribute("employee")Employee employee,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors())
        {
            return "new-employee-page";
        }
        else {
            employeeService.addEmployee(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/list")
    public String allEmployees(Model model){
        List<Employee> employees = employeeService.findAllEmployee();
        model.addAttribute("employees", employees);
        return "employee-informations";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employee/list";
    }

    @GetMapping("/update/form")
    public String updateEmployee(@RequestParam("employeeId") Integer id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);
        return "new-employee-page";
    }

}
