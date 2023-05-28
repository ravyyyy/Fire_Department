package com.example.fire_department.controllers;

import com.example.fire_department.models.DutyShift;
import com.example.fire_department.repositories.DutyShiftRepository;
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
public class DutyShiftController {
    @Autowired
    DutyShiftRepository dutyShiftRepository;

    @GetMapping("/dutyshifts")
    public ResponseEntity<List<DutyShift>> getAllDutyShifts(@RequestParam(required = false) Integer employeeId) {
        try {
            List<DutyShift> dutyShifts = new ArrayList<>();

            if (employeeId == null) {
                dutyShifts.addAll(dutyShiftRepository.findAll());
            } else {
                dutyShifts.addAll(dutyShiftRepository.findByEmployeeId(employeeId));
            }

            if (dutyShifts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(dutyShifts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/dutyshifts")
    public ResponseEntity<DutyShift> createDutyShift(@RequestBody DutyShift dutyShift) {
        try {
            DutyShift _dutyShift = dutyShiftRepository
                    .save(new DutyShift(dutyShift.getEmployeeId(), dutyShift.getShiftDate()));
            return new ResponseEntity<>(_dutyShift, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dutyshifts/{dutyShiftId}")
    public ResponseEntity<DutyShift> updateDutyShift(@PathVariable("dutyShiftId") Integer dutyShiftId,
                                                   @RequestBody DutyShift dutyShift) {
        Optional<DutyShift> dutyShiftData = dutyShiftRepository.findById(dutyShiftId);
        if (dutyShiftData.isPresent()) {
            DutyShift _dutyshift = dutyShiftData.get();
            _dutyshift.setEmployeeId(dutyShift.getEmployeeId());
            _dutyshift.setShiftDate(dutyShift.getShiftDate());
            return new ResponseEntity<>(dutyShiftRepository.save(_dutyshift), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dutyshifts")
    public ResponseEntity<HttpStatus> deleteAllDutyShifts() {
        try {
            dutyShiftRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dutyshifts/{dutyShiftId}")
    public ResponseEntity<HttpStatus> deleteDutyShift(@PathVariable("dutyShiftId") Integer dutyShiftId) {
        try {
            dutyShiftRepository.deleteById(dutyShiftId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
