package com.example.fire_department.controllers;

import com.example.fire_department.models.SpecialVehicleIntervention;
import com.example.fire_department.repositories.SpecialVehicleInterventionRepository;
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
public class SpecialVehicleInterventionController {
    @Autowired
    SpecialVehicleInterventionRepository specialVehicleInterventionRepository;

    @GetMapping("/specialvehicleinterventions")
    public ResponseEntity<List<SpecialVehicleIntervention>> getAllSpecialVehicleInterventions(@RequestParam(required = false) String licencePlateNumber) {
        try {
            List<SpecialVehicleIntervention> specialvehicleinterventions = new ArrayList<>();

            if (licencePlateNumber == null) {
                specialvehicleinterventions.addAll(specialVehicleInterventionRepository.findAll());
            } else {
                specialvehicleinterventions.addAll(specialVehicleInterventionRepository.findByLicencePlateNumber(licencePlateNumber));
            }

            if (specialvehicleinterventions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(specialvehicleinterventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/specialvehicleinterventions")
    public ResponseEntity<SpecialVehicleIntervention> createSpecialVehicleIntervention(@RequestBody SpecialVehicleIntervention specialVehicleIntervention) {
        try {
            SpecialVehicleIntervention _specialVehicleIntervention = specialVehicleInterventionRepository
                    .save(new SpecialVehicleIntervention(specialVehicleIntervention.getInterventionId(), specialVehicleIntervention.getLicencePlateNumber()));
            return new ResponseEntity<>(_specialVehicleIntervention, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/specialvehicleinterventions/{interventionId}")
    public ResponseEntity<SpecialVehicleIntervention> updateSpecialVehicleIntervention(@PathVariable("interventionId") Integer interventionId,
                                                           @RequestBody SpecialVehicleIntervention specialVehicleIntervention) {
        Optional<SpecialVehicleIntervention> specialVehicleInterventionData = specialVehicleInterventionRepository.findById(interventionId);
        if (specialVehicleInterventionData.isPresent()) {
            SpecialVehicleIntervention _specialVehicleIntervention = specialVehicleInterventionData.get();
            _specialVehicleIntervention.setLicencePlateNumber(specialVehicleIntervention.getLicencePlateNumber());
            return new ResponseEntity<>(specialVehicleInterventionRepository.save(_specialVehicleIntervention), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/specialvehicleinterventions")
    public ResponseEntity<HttpStatus> deleteAllSpecialVehicleInterventions() {
        try {
            specialVehicleInterventionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/specialvehicleinterventions/{interventionId}")
    public ResponseEntity<HttpStatus> deleteSpecialVehicle(@PathVariable("interventionId") Integer interventionId) {
        try {
            specialVehicleInterventionRepository.deleteById(interventionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
