package com.example.fire_department.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "intervention_crew")
public class InterventionCrew {
    @Id
    @Column(name = "intervention_id")
    private Integer interventionId;
    @Column(name = "employee_id")
    private Integer employeeId;

    public InterventionCrew() {

    }

    public InterventionCrew(Integer interventionId, Integer employeeId) {
        this.interventionId = interventionId;
        this.employeeId = employeeId;
    }

    public Integer getInterventionId() {
        return interventionId;
    }

    public void setInterventionId(Integer interventionId) {
        this.interventionId = interventionId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
