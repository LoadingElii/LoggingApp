package com.loadingeli.chapstickDistribution.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee saveEmployee(Employee employee) {
        System.out.println("Employee is: " + employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee foundedEmployee = employeeRepository.getReferenceById(id);

        foundedEmployee.setName(employee.getName());
        foundedEmployee.setRole(employee.getRole());
        foundedEmployee.setEmail(employee.getEmail());
        foundedEmployee.setHours(employee.getHours());

        return employeeRepository.save(foundedEmployee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesById(List<Long> employeesIDS) {
        return employeeRepository.findAllById(employeesIDS);
    }
}
