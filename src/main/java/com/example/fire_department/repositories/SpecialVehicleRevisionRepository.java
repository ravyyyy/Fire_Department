package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.SpecialVehicleRevision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialVehicleRevisionRepository extends JpaRepository<SpecialVehicleRevision, Integer> {
    List<SpecialVehicleRevision> findByService(String service);
}
