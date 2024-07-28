package com.loadingeli.chapstickDistribution.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/employee")
@CrossOrigin
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        System.out.println("Employee is in Controller: " + employee);

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") Long id, @RequestBody Employee employee) {

        return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteEmployeeById(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
