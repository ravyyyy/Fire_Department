package com.example.fire_department.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    @Column(name = "unit_id", length = 15)
    private String unitId;
    @Column(name = "badge_id", length = 30, nullable = false)
    private String badgeId;
    @Column(name = "employee_equipment_id")
    private Integer employeeEquipmentId;
    @Column(name = "interventions_count")
    private Integer interventionsCount;
    @Column(name = "length_of_service", length = 20)
    private String lengthOfService;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "title", length = 20)
    private String title;
    @Column(name = "employee_state", length = 25)
    private String employeeState;
    @Column(name = "employee_type_id")
    private Integer employeeTypeId;
    @Column(name = "employee_name", length = 20)
    private String employeeName;
    @Column(name = "employee_surname", length = 20)
    private String employeeSurname;

    public Employee() {

    }

    public Employee(String unitId, String badgeId, Integer employeeEquipmentId, Integer interventionsCount,
                    String lengthOfService, Integer salary, String title, String employeeState, Integer employeeTypeId,
                    String employeeName, String employeeSurname) {
        this.unitId = unitId;
        this.badgeId = badgeId;
        this.employeeEquipmentId = employeeEquipmentId;
        this.interventionsCount = interventionsCount;
        this.lengthOfService = lengthOfService;
        this.salary = salary;
        this.title = title;
        this.employeeState = employeeState;
        this.employeeTypeId = employeeTypeId;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public Integer getEmployeeEquipmentId() {
        return employeeEquipmentId;
    }

    public void setEmployeeEquipmentId(Integer employeeEquipmentId) {
        this.employeeEquipmentId = employeeEquipmentId;
    }

    public Integer getInterventionsCount() {
        return interventionsCount;
    }

    public void setInterventionsCount(Integer interventionsCount) {
        this.interventionsCount = interventionsCount;
    }

    public String getLengthOfService() {
        return lengthOfService;
    }

    public void setLengthOfService(String lengthOfService) {
        this.lengthOfService = lengthOfService;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public Integer getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Integer employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }
}
