package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention, Integer> {
    List<Intervention> findByInterventionLeaderId(Integer interventionLeaderId);
}
