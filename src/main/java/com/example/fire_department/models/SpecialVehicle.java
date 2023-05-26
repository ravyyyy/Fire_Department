package com.example.fire_department.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "special_vehicle")
public class SpecialVehicle {
    @Id
    @Column(name = "licence_plate_number", length = 15)
    private String licencePlateNumber;
    @Column(name = "unit_id", length = 15)
    private String unitId;
    @Column(name = "special_vehicle_type", length = 100)
    private String specialVehicleType;
    @Column(name = "vehicle_driver_id")
    private Integer vehicleDriverId;
    @Column(name = "vehicle_condition", length = 25)
    private String vehicleCondition;
    @Column(name = "mileage", length = 10)
    private String mileage;
    @Column(name = "fabrication_year")
    private Integer fabricationYear;
    @Column(name = "interventions_count")
    private Integer interventionsCount;
    @Column(name = "vehicleEquipmentId")
    private Integer vehicleEquipmentId;

    public SpecialVehicle() {

    }

    public SpecialVehicle(String licencePlateNumber, String unitId, String specialVehicleType, Integer vehicleDriverId,
                          String vehicleCondition, String mileage, Integer fabricationYear, Integer interventionsCount,
                          Integer vehicleEquipmentId) {
        this.licencePlateNumber = licencePlateNumber;
        this.unitId = unitId;
        this.specialVehicleType = specialVehicleType;
        this.vehicleDriverId = vehicleDriverId;
        this.vehicleCondition = vehicleCondition;
        this.mileage = mileage;
        this.fabricationYear = fabricationYear;
        this.interventionsCount = interventionsCount;
        this.vehicleEquipmentId = vehicleEquipmentId;
    }

    public String getLicencePlateNumber() {
        return licencePlateNumber;
    }

    public void setLicencePlateNumber(String licencePlateNumber) {
        this.licencePlateNumber = licencePlateNumber;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getSpecialVehicleType() {
        return specialVehicleType;
    }

    public void setSpecialVehicleType(String specialVehicleType) {
        this.specialVehicleType = specialVehicleType;
    }

    public Integer getVehicleDriverId() {
        return vehicleDriverId;
    }

    public void setVehicleDriverId(Integer vehicleDriverId) {
        this.vehicleDriverId = vehicleDriverId;
    }

    public String getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(String vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public Integer getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(Integer fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public Integer getInterventionsCount() {
        return interventionsCount;
    }

    public void setInterventionsCount(Integer interventionsCount) {
        this.interventionsCount = interventionsCount;
    }

    public Integer getVehicleEquipmentId() {
        return vehicleEquipmentId;
    }

    public void setVehicleEquipmentId(Integer vehicleEquipmentId) {
        this.vehicleEquipmentId = vehicleEquipmentId;
    }
}
