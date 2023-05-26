package com.example.fire_department.controllers;

import com.example.fire_department.models.SpecialVehicleType;
import com.example.fire_department.models.VehicleEquipment;
import com.example.fire_department.repositories.VehicleEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class VehicleEquipmentController {
    @Autowired
    VehicleEquipmentRepository vehicleEquipmentRepository;

    @GetMapping("/vehicleequipments")
    public ResponseEntity<List<VehicleEquipment>> getAllVehicleEquipments(@RequestParam(required = false) String equipmentCondition) {
        try {
            List<VehicleEquipment> vehicleEquipments = new ArrayList<>();

            if (equipmentCondition == null) {
                vehicleEquipments.addAll(vehicleEquipmentRepository.findAll());
            } else {
                vehicleEquipments.addAll(vehicleEquipmentRepository.findByEquipmentCondition(equipmentCondition));
            }

            if (vehicleEquipments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(vehicleEquipments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vehicleequipments")
    public ResponseEntity<VehicleEquipment> createVehicleEquipment(@RequestBody VehicleEquipment vehicleEquipment) {
        try {
            VehicleEquipment _vehicleEquipment = vehicleEquipmentRepository
                    .save(new VehicleEquipment(vehicleEquipment.getLicencePlateNumber(), vehicleEquipment.getEquipmentCondition(),
                            vehicleEquipment.getEquipmentName()));
            return new ResponseEntity<>(_vehicleEquipment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/vehicleequipments/{equipmentId}")
    public ResponseEntity<VehicleEquipment> updateVehicleEquipment(@PathVariable("equipmentId") Integer equipmentId,
                                                                       @RequestBody VehicleEquipment vehicleEquipment) {
        Optional<VehicleEquipment> vehicleEquipmentData = vehicleEquipmentRepository.findById(equipmentId);
        if (vehicleEquipmentData.isPresent()) {
            VehicleEquipment _vehicleEquipment = vehicleEquipmentData.get();
            _vehicleEquipment.setLicencePlateNumber(vehicleEquipment.getLicencePlateNumber());
            _vehicleEquipment.setEquipmentCondition(vehicleEquipment.getEquipmentCondition());
            _vehicleEquipment.setEquipmentName(vehicleEquipment.getEquipmentName());
            return new ResponseEntity<>(vehicleEquipmentRepository.save(_vehicleEquipment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/vehicleequipments")
    public ResponseEntity<HttpStatus> deleteAllVehicleEquipments() {
        try {
            vehicleEquipmentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/vehicleequipments/{equipmentId}")
    public ResponseEntity<HttpStatus> deleteVehicleEquipment(@PathVariable("equipmentId") Integer equipmentId) {
        try {
            vehicleEquipmentRepository.deleteById(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
