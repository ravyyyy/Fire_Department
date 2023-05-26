package com.example.fire_department.controllers;

import com.example.fire_department.models.SpecialVehicleType;
import com.example.fire_department.repositories.SpecialVehicleTypeRepository;
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
public class SpecialVehicleTypeController {
    @Autowired
    SpecialVehicleTypeRepository specialVehicleTypeRepository;

    @GetMapping("/specialvehicletypes")
    public ResponseEntity<List<SpecialVehicleType>> getAllSpecialVehicleTypes(@RequestParam(required = false) String specialVehicleBatch) {
        try {
            List<SpecialVehicleType> specialVehicleTypes = new ArrayList<>();

            if (specialVehicleBatch == null) {
                specialVehicleTypes.addAll(specialVehicleTypeRepository.findAll());
            } else {
                specialVehicleTypes.addAll(specialVehicleTypeRepository.findBySpecialVehicleBatch(specialVehicleBatch));
            }

            if (specialVehicleTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(specialVehicleTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/specialvehicletypes")
    public ResponseEntity<SpecialVehicleType> createSpecialVehicleType(@RequestBody SpecialVehicleType specialVehicleType) {
        try {
            SpecialVehicleType _specialVehicleType = specialVehicleTypeRepository
                    .save(new SpecialVehicleType(specialVehicleType.getCategoryName(), specialVehicleType.getSpecialVehicleBatch()));
            return new ResponseEntity<>(_specialVehicleType, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/specialvehicletypes/{categoryName}")
    public ResponseEntity<SpecialVehicleType> updateSpecialVehicleType(@PathVariable("categoryName") String categoryName,
                                                         @RequestBody SpecialVehicleType specialVehicleType) {
        Optional<SpecialVehicleType> specialVehicleTypeData = specialVehicleTypeRepository.findById(categoryName);
        if (specialVehicleTypeData.isPresent()) {
            SpecialVehicleType _specialVehicleType = specialVehicleTypeData.get();
            _specialVehicleType.setCategoryName(specialVehicleType.getCategoryName());
            _specialVehicleType.setSpecialVehicleBatch(specialVehicleType.getSpecialVehicleBatch());
            return new ResponseEntity<>(specialVehicleTypeRepository.save(_specialVehicleType), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/specialvehicletypes")
    public ResponseEntity<HttpStatus> deleteAllSpecialVehicleTypes() {
        try {
            specialVehicleTypeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/specialvehicletypes/{categoryName}")
    public ResponseEntity<HttpStatus> deleteSpecialVehicleType(@PathVariable("categoryName") String categoryName) {
        try {
            specialVehicleTypeRepository.deleteById(categoryName);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
