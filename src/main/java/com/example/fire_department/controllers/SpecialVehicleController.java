package com.example.fire_department.controllers;

import com.example.fire_department.models.SpecialVehicle;
import com.example.fire_department.repositories.SpecialVehicleRepository;
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
public class SpecialVehicleController {
    @Autowired
    SpecialVehicleRepository specialVehicleRepository;

    @GetMapping("/specialvehicles")
    public ResponseEntity<List<SpecialVehicle>> getAllSpecialVehicles(@RequestParam(required = false) Integer fabricationYear) {
        try {
            List<SpecialVehicle> specialVehicles = new ArrayList<>();

            if (fabricationYear == null) {
                specialVehicles.addAll(specialVehicleRepository.findAll());
            } else {
                specialVehicles.addAll(specialVehicleRepository.findByFabricationYear(fabricationYear));
            }

            if (specialVehicles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(specialVehicles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/specialvehicles")
    public ResponseEntity<SpecialVehicle> createSpecialVehicle(@RequestBody SpecialVehicle specialVehicle) {
        try {
            SpecialVehicle _specialVehicle = specialVehicleRepository
                    .save(new SpecialVehicle(specialVehicle.getLicencePlateNumber(), specialVehicle.getUnitId(),
                            specialVehicle.getSpecialVehicleType(), specialVehicle.getVehicleDriverId(), specialVehicle.getVehicleCondition(),
                            specialVehicle.getMileage(), specialVehicle.getFabricationYear(), specialVehicle.getInterventionsCount(),
                            specialVehicle.getVehicleEquipmentId()));
            return new ResponseEntity<>(_specialVehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/specialvehicles/{licencePlateNumber}")
    public ResponseEntity<SpecialVehicle> updateSpecialVehicle(@PathVariable("licencePlateNumber") String licencePlateNumber,
                                                         @RequestBody SpecialVehicle specialVehicle) {
        Optional<SpecialVehicle> specialVehicleData = specialVehicleRepository.findById(licencePlateNumber);
        if (specialVehicleData.isPresent()) {
            SpecialVehicle _specialVehicle = specialVehicleData.get();
            _specialVehicle.setLicencePlateNumber(specialVehicle.getLicencePlateNumber());
            _specialVehicle.setUnitId(specialVehicle.getUnitId());
            _specialVehicle.setSpecialVehicleType(specialVehicle.getSpecialVehicleType());
            _specialVehicle.setVehicleDriverId(specialVehicle.getVehicleDriverId());
            _specialVehicle.setVehicleCondition(specialVehicle.getVehicleCondition());
            _specialVehicle.setMileage(specialVehicle.getMileage());
            _specialVehicle.setFabricationYear(specialVehicle.getFabricationYear());
            _specialVehicle.setInterventionsCount(specialVehicle.getInterventionsCount());
            _specialVehicle.setVehicleEquipmentId(specialVehicle.getVehicleEquipmentId());
            return new ResponseEntity<>(specialVehicleRepository.save(_specialVehicle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/specialvehicles")
    public ResponseEntity<HttpStatus> deleteAllSpecialVehicles() {
        try {
            specialVehicleRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/specialvehicles/{licencePlateNumber}")
    public ResponseEntity<HttpStatus> deleteSpecialVehicle(@PathVariable("licencePlateNumber") String licencePlateNumber) {
        try {
            specialVehicleRepository.deleteById(licencePlateNumber);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
