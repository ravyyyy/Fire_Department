package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.VehicleEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleEquipmentRepository extends JpaRepository<VehicleEquipment, Integer> {
    List<VehicleEquipment> findByEquipmentCondition(String equipmentCondition);
}
