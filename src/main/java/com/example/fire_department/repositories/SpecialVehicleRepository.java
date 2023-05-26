package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.SpecialVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialVehicleRepository extends JpaRepository<SpecialVehicle, String> {
    List<SpecialVehicle> findByFabricationYear(Integer fabricationYear);
}
