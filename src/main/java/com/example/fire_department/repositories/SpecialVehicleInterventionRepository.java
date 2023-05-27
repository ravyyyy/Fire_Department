package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.SpecialVehicleIntervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialVehicleInterventionRepository extends JpaRepository<SpecialVehicleIntervention, Integer> {
    List<SpecialVehicleIntervention> findByLicencePlateNumber(String licencePlateNumber);
}
