package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.EmployeeEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeEquipmentRepository extends JpaRepository<EmployeeEquipment, Integer> {
    List<EmployeeEquipment> findByEquipmentCondition(String equipmentCondition);
}
