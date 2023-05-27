package com.example.fire_department.controllers;

import com.example.fire_department.models.InterventionCrew;
import com.example.fire_department.repositories.InterventionCrewRepository;
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
public class InterventionCrewController {
    @Autowired
    InterventionCrewRepository interventionCrewRepository;

    @GetMapping("/interventioncrews")
    public ResponseEntity<List<InterventionCrew>> getAllInterventionCrews(@RequestParam(required = false) Integer employeeId) {
        try {
            List<InterventionCrew> interventionCrews = new ArrayList<>();

            if (employeeId == null) {
                interventionCrews.addAll(interventionCrewRepository.findAll());
            } else {
                interventionCrews.addAll(interventionCrewRepository.findByEmployeeId(employeeId));
            }

            if (interventionCrews.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(interventionCrews, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/interventioncrews")
    public ResponseEntity<InterventionCrew> createInterventionCrew(@RequestBody InterventionCrew interventionCrew) {
        try {
            InterventionCrew _interventionCrew = interventionCrewRepository
                    .save(new InterventionCrew(interventionCrew.getInterventionId(), interventionCrew.getEmployeeId()));
            return new ResponseEntity<>(_interventionCrew, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/interventioncrews/{interventionId}")
    public ResponseEntity<InterventionCrew> updateInterventionCrew(@PathVariable("interventionId") Integer interventionId,
                                                           @RequestBody InterventionCrew interventionCrew) {
        Optional<InterventionCrew> interventionCrewData = interventionCrewRepository.findById(interventionId);
        if (interventionCrewData.isPresent()) {
            InterventionCrew _interventionCrew = interventionCrewData.get();
            _interventionCrew.setEmployeeId(interventionCrew.getEmployeeId());
            return new ResponseEntity<>(interventionCrewRepository.save(_interventionCrew), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/interventioncrews")
    public ResponseEntity<HttpStatus> deleteAllInterventionCrews() {
        try {
            interventionCrewRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/interventioncrews/{interventionId}")
    public ResponseEntity<HttpStatus> deleteInterventionCrew(@PathVariable("interventionId") Integer interventionId) {
        try {
            interventionCrewRepository.deleteById(interventionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
