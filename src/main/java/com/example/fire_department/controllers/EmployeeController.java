package com.example.fire_department.controllers;

import com.example.fire_department.models.Employee;
import com.example.fire_department.models.EmployeeEquipment;
import com.example.fire_department.repositories.EmployeeEquipmentRepository;
import com.example.fire_department.repositories.EmployeeRepository;
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
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String title) {
        try {
            List<Employee> employees = new ArrayList<>();

            if (title == null) {
                employees.addAll(employeeRepository.findAll());
            } else {
                employees.addAll(employeeRepository.findByTitle(title));
            }

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = employeeRepository
                    .save(new Employee(employee.getUnitId(), employee.getBadgeId(), employee.getEmployeeEquipmentId(),
                            employee.getInterventionsCount(), employee.getLengthOfService(), employee.getSalary(),
                            employee.getTitle(), employee.getEmployeeState(), employee.getEmployeeTypeId(),
                            employee.getEmployeeName(), employee.getEmployeeSurname()));
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") Integer employeeId,
                                                                     @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeRepository.findById(employeeId);
        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setEmployeeName(employee.getEmployeeName());
            _employee.setEmployeeState(employee.getEmployeeState());
            _employee.setEmployeeEquipmentId(employee.getEmployeeEquipmentId());
            _employee.setEmployeeSurname(employee.getEmployeeSurname());
            _employee.setEmployeeTypeId(employee.getEmployeeTypeId());
            _employee.setBadgeId(employee.getBadgeId());
            _employee.setTitle(employee.getTitle());
            _employee.setSalary(employee.getSalary());
            _employee.setUnitId(employee.getUnitId());
            _employee.setInterventionsCount(employee.getInterventionsCount());
            _employee.setLengthOfService(employee.getLengthOfService());
            return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees")
    public ResponseEntity<HttpStatus> deleteAllEmployees() {
        try {
            employeeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
