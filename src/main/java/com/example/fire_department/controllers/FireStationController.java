package com.example.fire_department.controllers;

import com.example.fire_department.models.FireStation;
import com.example.fire_department.repositories.FireStationRepository;
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
public class FireStationController {
    @Autowired
    FireStationRepository fireStationRepository;

    @GetMapping("/firestations")
    public ResponseEntity<List<FireStation>> getAllFireStations(@RequestParam(required = false) String city) {
        try {
            List<FireStation> fireStations = new ArrayList<>();

            if (city == null) {
                fireStations.addAll(fireStationRepository.findAll());
            } else {
                fireStations.addAll(fireStationRepository.findByCity(city));
            }

            if (fireStations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fireStations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/firestations")
    public ResponseEntity<FireStation> createFireStation(@RequestBody FireStation fireStation) {
        try {
            FireStation _fireStation = fireStationRepository
                    .save(new FireStation(fireStation.getUnitId(), fireStation.getAddress(), fireStation.getCity(),
                            fireStation.getCounty(), fireStation.getEmployeesCount(), fireStation.getSpecialVehiclesCount(),
                            fireStation.getInterventionsCount()));
            return new ResponseEntity<>(_fireStation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/firestations/{unitId}")
    public ResponseEntity<FireStation> updateFireStation(@PathVariable("unitId") String unitId,
                                                         @RequestBody FireStation fireStation) {
        Optional<FireStation> fireStationData = fireStationRepository.findById(unitId);
        if (fireStationData.isPresent()) {
            FireStation _fireStation = fireStationData.get();
            _fireStation.setAddress(fireStation.getAddress());
            _fireStation.setCity(fireStation.getCity());
            _fireStation.setCounty(fireStation.getCounty());
            _fireStation.setEmployeesCount(fireStation.getEmployeesCount());
            _fireStation.setInterventionsCount(fireStation.getInterventionsCount());
            _fireStation.setSpecialVehiclesCount(fireStation.getSpecialVehiclesCount());
            return new ResponseEntity<>(fireStationRepository.save(_fireStation), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/firestations")
    public ResponseEntity<HttpStatus> deleteAllFireStations() {
        try {
            fireStationRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/firestations/{unitId}")
    public ResponseEntity<HttpStatus> deleteFireStation(@PathVariable("unitId") String unitId) {
        try {
            fireStationRepository.deleteById(unitId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/firestations/county")
    public ResponseEntity<List<FireStation>> getAllFireStationsByCounty(@RequestParam() String county) {
        try {
            List<FireStation> fireStations = fireStationRepository.findByCounty(county);

            if (fireStations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fireStations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
