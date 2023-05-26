package com.example.fire_department.models;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_equipment")
public class VehicleEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer equipmentId;
    @Column(name = "licence_plate_number", length = 15)
    private String licencePlateNumber;
    @Column(name = "equipment_condition", length = 25)
    private String equipmentCondition;
    @Column(name = "equipment_name", length = 35)
    private String equipmentName;

    public VehicleEquipment() {

    }

    public VehicleEquipment(String licencePlateNumber, String equipmentCondition, String equipmentName) {
        this.licencePlateNumber = licencePlateNumber;
        this.equipmentCondition = equipmentCondition;
        this.equipmentName = equipmentName;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }

    public String getEquipmentCondition() {
        return equipmentCondition;
    }

    public void setEquipmentCondition(String equipmentCondition) {
        this.equipmentCondition = equipmentCondition;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
