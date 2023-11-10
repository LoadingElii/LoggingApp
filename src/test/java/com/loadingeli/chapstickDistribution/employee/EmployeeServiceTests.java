package com.loadingeli.chapstickDistribution.employee;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void EmployeeService_add_NewEmployee() {

        Employee firstEmployee = new Employee(1l,"Jeese","Designer");

        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(firstEmployee);

        Employee savedEmployee = employeeService.saveEmployee(firstEmployee);

        Assertions.assertThat(savedEmployee).isNotNull();
    }

}
