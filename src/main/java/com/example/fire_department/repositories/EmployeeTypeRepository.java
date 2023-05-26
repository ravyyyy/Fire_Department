package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
    List<EmployeeType> findByEmployeeTypeName(String employeeTypeName);
}
