package com.example.fire_department.models;

import jakarta.persistence.*;

@Entity
@Table(name = "special_vehicle_intervention")
public class SpecialVehicleIntervention {
    @Id
    @Column(name = "intervention_id")
    private Integer interventionId;
    @Column(name = "licence_plate_number", length = 15)
    private String licencePlateNumber;

    public SpecialVehicleIntervention() {

    }

    public SpecialVehicleIntervention(Integer interventionId, String licencePlateNumber) {
        this.interventionId = interventionId;
        this.licencePlateNumber = licencePlateNumber;
    }

    public Integer getInterventionId() {
        return interventionId;
    }

    public void setInterventionId(Integer interventionId) {
        this.interventionId = interventionId;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }
}
