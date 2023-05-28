package com.example.fire_department.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fire_station")
public class FireStation {
    @Id
    @Column(name = "unit_id", length = 15)
    private String unitId;
    @Column(name = "address", length = 30, nullable = false)
    private String address;
    @Column(name = "city", length = 30, nullable = false)
    private String city;
    @Column(name = "county", length = 30, nullable = false)
    private String county;
    @Column(name = "employees_count")
    private Integer employeesCount;
    @Column(name = "special_vehicles_count")
    private Integer specialVehiclesCount;
    @Column(name = "interventions_count")
    private Integer interventionsCount;

    public FireStation() {

    }

    public FireStation(String unitId, String address, String city, String county,
                       Integer employeesCount, Integer specialVehiclesCount, Integer interventionsCount) {
        this.unitId = unitId;
        this.address = address;
        this.city = city;
        this.county = county;
        this.employeesCount = employeesCount;
        this.specialVehiclesCount = specialVehiclesCount;
        this.interventionsCount = interventionsCount;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public Integer getInterventionsCount() {
        return interventionsCount;
    }

    public void setInterventionsCount(Integer interventionsCount) {
        this.interventionsCount = interventionsCount;
    }

    public Integer getSpecialVehiclesCount() {
        return specialVehiclesCount;
    }

    public void setSpecialVehiclesCount(Integer specialVehiclesCount) {
        this.specialVehiclesCount = specialVehiclesCount;
    }
}
