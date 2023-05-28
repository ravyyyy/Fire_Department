package com.example.fire_department;

import com.example.fire_department.models.FireStation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FireStationTests {
    @Test
    public void testFireStationConstructorAndGetters() {
        String unitId = "BZ-24714";
        String address = "Str. Nucului";
        String city = "Buzau";
        String county = "Buzau";
        Integer employeesCount = 30;
        Integer specialVehiclesCount = 8;
        Integer interventionsCount = 234;

        FireStation fireStation = new FireStation(unitId, address, city, county, employeesCount, specialVehiclesCount, interventionsCount);

        assertNotNull(fireStation);
        assertEquals(unitId, fireStation.getUnitId());
        assertEquals(address, fireStation.getAddress());
        assertEquals(city, fireStation.getCity());
        assertEquals(county, fireStation.getCounty());
        assertEquals(employeesCount, fireStation.getEmployeesCount());
        assertEquals(specialVehiclesCount, fireStation.getSpecialVehiclesCount());
        assertEquals(interventionsCount, fireStation.getInterventionsCount());
    }

    @Test
    public void testFireStationGetters() {
        String address = "Str. Nucului";
        String city = "Buzau";
        String county = "Buzau";
        Integer employeesCount = 30;
        Integer specialVehiclesCount = 8;
        Integer interventionsCount = 234;

        FireStation fireStation = new FireStation();
        fireStation.setAddress(address);
        fireStation.setCity(city);
        fireStation.setCounty(county);
        fireStation.setEmployeesCount(employeesCount);
        fireStation.setSpecialVehiclesCount(specialVehiclesCount);
        fireStation.setInterventionsCount(interventionsCount);

        assertNotNull(fireStation);
        assertEquals(address, fireStation.getAddress());
        assertEquals(city, fireStation.getCity());
        assertEquals(county, fireStation.getCounty());
        assertEquals(employeesCount, fireStation.getEmployeesCount());
        assertEquals(specialVehiclesCount, fireStation.getSpecialVehiclesCount());
        assertEquals(interventionsCount, fireStation.getInterventionsCount());
    }
}
