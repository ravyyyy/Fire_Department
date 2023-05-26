package com.example.fire_department.models;

import jakarta.persistence.*;

@Entity
@Table(name = "special_vehicle_type")
public class SpecialVehicleType {
    @Id
    @Column(name = "category_name", length = 100)
    private String categoryName;
    @Column(name = "special_vehicle_batch", length = 25)
    private String specialVehicleBatch;

    public SpecialVehicleType() {

    }

    public SpecialVehicleType(String categoryName, String specialVehicleBatch) {
        this.categoryName = categoryName;
        this.specialVehicleBatch = specialVehicleBatch;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSpecialVehicleBatch() {
        return specialVehicleBatch;
    }

    public void setSpecialVehicleBatch(String specialVehicleBatch) {
        this.specialVehicleBatch = specialVehicleBatch;
    }
}
