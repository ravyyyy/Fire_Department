package com.example.fire_department.repositories;

import java.util.List;
import com.example.fire_department.models.DutyShift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DutyShiftRepository extends JpaRepository<DutyShift, Integer> {
    List<DutyShift> findByEmployeeId(Integer employeeId);
}
