package com.example.fire_department.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_type")
public class EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeTypeId;
    @Column(name = "employee_type_name", length = 45)
    private String employeeTypeName;
    @Column(name = "retirement_age")
    private Integer retirementAge;

    public EmployeeType() {

    }

    public EmployeeType(String employeeTypeName, Integer retirementAge) {
        this.employeeTypeName = employeeTypeName;
        this.retirementAge = retirementAge;
    }

    public Integer getEmployeeTypeId() {
        return employeeTypeId;
    }

    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    public Integer getRetirementAge() {
        return retirementAge;
    }

    public void setRetirementAge(Integer retirementAge) {
        this.retirementAge = retirementAge;
    }
}
