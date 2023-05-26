package com.example.fire_department.controllers;

import com.example.fire_department.models.EmployeeType;
import com.example.fire_department.repositories.EmployeeTypeRepository;
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
public class EmployeeTypeController {
    @Autowired
    EmployeeTypeRepository employeeTypeRepository;

    @GetMapping("/employeetypes")
    public ResponseEntity<List<EmployeeType>> getAllEmployeeTypes(@RequestParam(required = false) String employeeTypeName) {
        try {
            List<EmployeeType> employeeTypes = new ArrayList<>();

            if (employeeTypeName == null) {
                employeeTypes.addAll(employeeTypeRepository.findAll());
            } else {
                employeeTypes.addAll(employeeTypeRepository.findByEmployeeTypeName(employeeTypeName));
            }

            if (employeeTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeeTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employeetypes")
    public ResponseEntity<EmployeeType> createEmployeeType(@RequestBody EmployeeType employeeType) {
        try {
            EmployeeType _employeeType = employeeTypeRepository.save(new EmployeeType(employeeType.getEmployeeTypeName(),
                    employeeType.getRetirementAge()));
            return new ResponseEntity<>(_employeeType, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employeetypes/{employeeTypeId}")
    public ResponseEntity<EmployeeType> updateEmployeeType(@PathVariable("employeeTypeId") Integer employeeTypeId,
                                                                     @RequestBody EmployeeType employeeType) {
        Optional<EmployeeType> employeeTypeData = employeeTypeRepository.findById(employeeTypeId);
        if (employeeTypeData.isPresent()) {
            EmployeeType _employeeType = employeeTypeData.get();
            _employeeType.setEmployeeTypeName(employeeType.getEmployeeTypeName());
            _employeeType.setRetirementAge(employeeType.getRetirementAge());
            return new ResponseEntity<>(employeeTypeRepository.save(_employeeType), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employeetypes")
    public ResponseEntity<HttpStatus> deleteAllEmployeeTypes() {
        try {
            employeeTypeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employeetypes/{employeeTypeId}")
    public ResponseEntity<HttpStatus> deleteEmployeeType(@PathVariable("employeeTypeId") Integer employeeTypeId) {
        try {
            employeeTypeRepository.deleteById(employeeTypeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
