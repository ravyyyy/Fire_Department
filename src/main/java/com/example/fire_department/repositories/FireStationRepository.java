package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireStationRepository extends JpaRepository<FireStation, String> {
    List<FireStation> findByCity(String city);
    List<FireStation> findByCounty(String county);
}
