package com.bangvan.project.repository;

import com.bangvan.project.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // that's it ... no need to write any code!
}
