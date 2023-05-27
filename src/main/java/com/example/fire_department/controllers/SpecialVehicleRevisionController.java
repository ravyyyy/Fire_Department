package com.example.fire_department.controllers;

import com.example.fire_department.models.SpecialVehicle;
import com.example.fire_department.models.SpecialVehicleRevision;
import com.example.fire_department.repositories.SpecialVehicleRepository;
import com.example.fire_department.repositories.SpecialVehicleRevisionRepository;
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
public class SpecialVehicleRevisionController {
    @Autowired
    SpecialVehicleRevisionRepository specialVehicleRevisionRepository;

    @GetMapping("/specialvehiclerevisions")
    public ResponseEntity<List<SpecialVehicleRevision>> getAllSpecialVehicleRevisions(@RequestParam(required = false) String service) {
        try {
            List<SpecialVehicleRevision> specialVehicleRevisions = new ArrayList<>();

            if (service == null) {
                specialVehicleRevisions.addAll(specialVehicleRevisionRepository.findAll());
            } else {
                specialVehicleRevisions.addAll(specialVehicleRevisionRepository.findByService(service));
            }

            if (specialVehicleRevisions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(specialVehicleRevisions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/specialvehiclerevisions")
    public ResponseEntity<SpecialVehicleRevision> createSpecialVehicleRevision(@RequestBody SpecialVehicleRevision specialVehicleRevision) {
        try {
            SpecialVehicleRevision _specialVehicleRevision = specialVehicleRevisionRepository
                    .save(new SpecialVehicleRevision(specialVehicleRevision.getLicencePlateNumber(), specialVehicleRevision.getRevisionDate(),
                            specialVehicleRevision.getRevisionDescription(), specialVehicleRevision.getService()));
            return new ResponseEntity<>(_specialVehicleRevision, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/specialvehiclerevisions/{revisionId}")
    public ResponseEntity<SpecialVehicleRevision> updateSpecialVehicleRevision(@PathVariable("revisionId") Integer revisionId,
                                                               @RequestBody SpecialVehicleRevision specialVehicleRevision) {
        Optional<SpecialVehicleRevision> specialVehicleRevisionData = specialVehicleRevisionRepository.findById(revisionId);
        if (specialVehicleRevisionData.isPresent()) {
            SpecialVehicleRevision _specialVehicleRevision = specialVehicleRevisionData.get();
            _specialVehicleRevision.setRevisionDate(specialVehicleRevision.getRevisionDate());
            _specialVehicleRevision.setRevisionDescription(specialVehicleRevision.getRevisionDescription());
            _specialVehicleRevision.setService(specialVehicleRevision.getService());
            _specialVehicleRevision.setLicencePlateNumber(specialVehicleRevision.getLicencePlateNumber());
            return new ResponseEntity<>(specialVehicleRevisionRepository.save(_specialVehicleRevision), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/specialvehiclerevisions")
    public ResponseEntity<HttpStatus> deleteAllSpecialVehicleRevisions() {
        try {
            specialVehicleRevisionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/specialvehiclerevisions/{revisionId}")
    public ResponseEntity<HttpStatus> deleteSpecialVehicleRevision(@PathVariable("revisionId") Integer revisionId) {
        try {
            specialVehicleRevisionRepository.deleteById(revisionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
