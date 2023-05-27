package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.SpecialVehicleCrew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialVehicleCrewRepository extends JpaRepository<SpecialVehicleCrew, String> {
    List<SpecialVehicleCrew> findByEmployeeId(Integer employeeId);
}
