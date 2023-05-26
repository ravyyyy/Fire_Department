package com.example.fire_department.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "duty_shift")
public class DutyShift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dutyShiftId;
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "shift_date")
    private Date shiftDate;

    public DutyShift() {

    }

    public DutyShift(Integer employeeId, Date shiftDate) {
        this.employeeId = employeeId;
        this.shiftDate = shiftDate;
    }

    public Integer getShiftId() {
        return dutyShiftId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }
}
