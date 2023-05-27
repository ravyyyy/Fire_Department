package com.example.fire_department.controllers;

import com.example.fire_department.models.SpecialVehicleCrew;
import com.example.fire_department.repositories.SpecialVehicleCrewRepository;
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
public class SpecialVehicleCrewController {
    @Autowired
    SpecialVehicleCrewRepository specialVehicleCrewRepository;

    @GetMapping("/specialvehiclecrews")
    public ResponseEntity<List<SpecialVehicleCrew>> getAllSpecialVehicleCrews(@RequestParam(required = false) Integer employeeId) {
        try {
            List<SpecialVehicleCrew> specialVehicleCrews = new ArrayList<>();

            if (employeeId == null) {
                specialVehicleCrews.addAll(specialVehicleCrewRepository.findAll());
            } else {
                specialVehicleCrews.addAll(specialVehicleCrewRepository.findByEmployeeId(employeeId));
            }

            if (specialVehicleCrews.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(specialVehicleCrews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/specialvehiclecrews")
    public ResponseEntity<SpecialVehicleCrew> createSpecialVehicleCrew(@RequestBody SpecialVehicleCrew specialVehicleCrew) {
        try {
            SpecialVehicleCrew _specialVehicleCrew = specialVehicleCrewRepository
                    .save(new SpecialVehicleCrew(specialVehicleCrew.getLicencePlateNumber(), specialVehicleCrew.getEmployeeId()));
            return new ResponseEntity<>(_specialVehicleCrew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/specialvehiclecrews/{licencePlateNumber}")
    public ResponseEntity<SpecialVehicleCrew> updateSpecialVehicleCrew(@PathVariable("licencePlateNumber") String licencePlateNumber,
                                                               @RequestBody SpecialVehicleCrew specialVehicleCrew) {
        Optional<SpecialVehicleCrew> specialVehicleCrewData = specialVehicleCrewRepository.findById(licencePlateNumber);
        if (specialVehicleCrewData.isPresent()) {
            SpecialVehicleCrew _specialVehicleCrew = specialVehicleCrewData.get();
            _specialVehicleCrew.setLicencePlateNumber(specialVehicleCrew.getLicencePlateNumber());
            _specialVehicleCrew.setEmployeeId(specialVehicleCrew.getEmployeeId());
            return new ResponseEntity<>(specialVehicleCrewRepository.save(_specialVehicleCrew), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/specialvehiclecrews")
    public ResponseEntity<HttpStatus> deleteAllSpecialVehicleCrews() {
        try {
            specialVehicleCrewRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/specialvehiclecrews/{licencePlateNumber}")
    public ResponseEntity<HttpStatus> deleteSpecialVehicleCrew(@PathVariable("licencePlateNumber") String licencePlateNumber) {
        try {
            specialVehicleCrewRepository.deleteById(licencePlateNumber);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
