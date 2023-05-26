package com.example.fire_department.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_equipment")
public class EmployeeEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeEquipmentId;
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "equipment_condition", length = 25)
    private String equipmentCondition;

    public EmployeeEquipment() {

    }

    public EmployeeEquipment(Integer employeeId, String equipmentCondition) {
        this.employeeId = employeeId;
        this.equipmentCondition = equipmentCondition;
    }

    public Integer getEmployeeEquipmentId() {
        return employeeEquipmentId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEquipmentCondition() {
        return equipmentCondition;
    }

    public void setEquipmentCondition(String equipmentCondition) {
        this.equipmentCondition = equipmentCondition;
    }
}
