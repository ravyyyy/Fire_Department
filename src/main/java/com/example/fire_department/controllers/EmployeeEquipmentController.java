package com.example.fire_department.controllers;

import com.example.fire_department.models.EmployeeEquipment;
import com.example.fire_department.repositories.EmployeeEquipmentRepository;
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
public class EmployeeEquipmentController {
    @Autowired
    EmployeeEquipmentRepository employeeEquipmentRepository;

    @GetMapping("/employeeequipments")
    public ResponseEntity<List<EmployeeEquipment>> getAllEmployeeEquipments(@RequestParam(required = false) String equipmentCondition) {
        try {
            List<EmployeeEquipment> employeeEquipments = new ArrayList<>();

            if (equipmentCondition == null) {
                employeeEquipments.addAll(employeeEquipmentRepository.findAll());
            } else {
                employeeEquipments.addAll(employeeEquipmentRepository.findByEquipmentCondition(equipmentCondition));
            }

            if (employeeEquipments.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeeEquipments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employeeequipments")
    public ResponseEntity<EmployeeEquipment> createEmployeeEquipment(@RequestBody EmployeeEquipment employeeEquipment) {
        try {
            EmployeeEquipment _employeeEquipment = employeeEquipmentRepository
                    .save(new EmployeeEquipment(employeeEquipment.getEmployeeId(),
                            employeeEquipment.getEquipmentCondition()));
            return new ResponseEntity<>(_employeeEquipment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employeeequipments/{equipmentId}")
    public ResponseEntity<EmployeeEquipment> updateEmployeeEquipment(@PathVariable("equipmentId") Integer equipmentId,
                                                         @RequestBody EmployeeEquipment employeeEquipment) {
        Optional<EmployeeEquipment> employeeEquipmentData = employeeEquipmentRepository.findById(equipmentId);
        if (employeeEquipmentData.isPresent()) {
            EmployeeEquipment _employeeEquipment = employeeEquipmentData.get();
            _employeeEquipment.setEmployeeId(employeeEquipment.getEmployeeId());
            _employeeEquipment.setEmployeeId(employeeEquipment.getEmployeeId());
            _employeeEquipment.setEquipmentCondition(employeeEquipment.getEquipmentCondition());
            return new ResponseEntity<>(employeeEquipmentRepository.save(_employeeEquipment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employeeequipments")
    public ResponseEntity<HttpStatus> deleteAllEmployeeEquipments() {
        try {
            employeeEquipmentRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employeeequipments/{equipmentId}")
    public ResponseEntity<HttpStatus> deleteEmployeeEquipment(@PathVariable("equipmentId") Integer equipmentId) {
        try {
            employeeEquipmentRepository.deleteById(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
