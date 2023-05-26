package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.SpecialVehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialVehicleTypeRepository extends JpaRepository<SpecialVehicleType, String> {
    List<SpecialVehicleType> findBySpecialVehicleBatch(String specialVehicleBatch);
}
