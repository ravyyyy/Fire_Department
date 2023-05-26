package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByTitle(String title);
}
