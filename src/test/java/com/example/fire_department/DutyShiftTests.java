package com.example.fire_department;

import com.example.fire_department.models.DutyShift;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DutyShiftTests {

    @Test
    public void testDutyShiftConstructorAndGetters() {
        Integer employeeId = 1;
        Date shiftDate = Date.valueOf("2023-05-28");

        DutyShift dutyShift = new DutyShift(employeeId, shiftDate);

        assertNotNull(dutyShift);
        assertEquals(employeeId, dutyShift.getEmployeeId());
        assertEquals(shiftDate, dutyShift.getShiftDate());
    }

    @Test
    public void testDutyShiftGetters() {
        Integer employeeId = 1;
        Date shiftDate = Date.valueOf("2023-05-28");

        DutyShift dutyShift = new DutyShift();
        dutyShift.setEmployeeId(employeeId);
        dutyShift.setShiftDate(shiftDate);

        assertNotNull(dutyShift);
        assertEquals(employeeId, dutyShift.getEmployeeId());
        assertEquals(shiftDate, dutyShift.getShiftDate());
    }
}
