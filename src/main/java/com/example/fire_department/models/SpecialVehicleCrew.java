package com.example.fire_department.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "special_vehicle_crew")
public class SpecialVehicleCrew {
    @Id
    @Column(name = "licence_plate_number", length = 15)
    private String licencePlateNumber;
    @Column(name = "employee_id")
    private Integer employeeId;

    public SpecialVehicleCrew() {

    }

    public SpecialVehicleCrew(String licencePlateNumber, Integer employeeId) {
        this.licencePlateNumber = licencePlateNumber;
        this.employeeId = employeeId;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
