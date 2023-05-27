package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.InterventionCrew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionCrewRepository extends JpaRepository<InterventionCrew, Integer> {
    List<InterventionCrew> findByEmployeeId(Integer employeeId);
}
