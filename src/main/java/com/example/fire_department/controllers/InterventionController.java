package com.example.fire_department.controllers;

import com.example.fire_department.models.Intervention;
import com.example.fire_department.repositories.InterventionRepository;
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
public class InterventionController {
    @Autowired
    InterventionRepository interventionRepository;

    @GetMapping("/interventions")
    public ResponseEntity<List<Intervention>> getAllInterventions(@RequestParam(required = false) Integer interventionLeaderId) {
        try {
            List<Intervention> interventions = new ArrayList<>();

            if (interventionLeaderId == null) {
                interventions.addAll(interventionRepository.findAll());
            } else {
                interventions.addAll(interventionRepository.findByInterventionLeaderId(interventionLeaderId));
            }

            if (interventions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(interventions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/interventions")
    public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention) {
        try {
            Intervention _intervention = interventionRepository
                    .save(new Intervention(intervention.getInterventionDate(), intervention.getInterventionType(),
                            intervention.getInterventionLeaderId(), intervention.getInterventionDuration()));
            return new ResponseEntity<>(_intervention, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/interventions/{interventionId}")
    public ResponseEntity<Intervention> updateIntervention(@PathVariable("interventionId") Integer interventionId,
                                                               @RequestBody Intervention intervention) {
        Optional<Intervention> interventionData = interventionRepository.findById(interventionId);
        if (interventionData.isPresent()) {
            Intervention _intervention = interventionData.get();
            _intervention.setInterventionDate(intervention.getInterventionDate());
            _intervention.setInterventionType(intervention.getInterventionType());
            _intervention.setInterventionLeaderId(intervention.getInterventionLeaderId());
            _intervention.setInterventionDuration(intervention.getInterventionDuration());
            return new ResponseEntity<>(interventionRepository.save(_intervention), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/interventions")
    public ResponseEntity<HttpStatus> deleteAllInterventions() {
        try {
            interventionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/interventions/{interventionId}")
    public ResponseEntity<HttpStatus> deleteIntervention(@PathVariable("interventionId") Integer interventionId) {
        try {
            interventionRepository.deleteById(interventionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
