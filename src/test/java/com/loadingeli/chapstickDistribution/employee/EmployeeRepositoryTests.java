package com.loadingeli.chapstickDistribution.employee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void EmployeeRepository_SaveAll_ReturnsSavedEmployee() {
        //Arrange
        Employee employee1 = new Employee(1L, "Mark","345love","345@gmail.com", "Engineer");

        //Act
        Employee saveEmployee = employeeRepository.save(employee1);

        //Assert
        Assertions.assertThat(saveEmployee).isNotNull();
        Assertions.assertThat(saveEmployee.getId()).isGreaterThan(0);
    }

    @Test
    public void EmployeeRepository_FindById_ReturnEmployee() {
        //Arrange
        Employee employee = new Employee(1L,"Harry","678win","345@gmail.com","Analyst");
        //Act
        employeeRepository.save(employee);
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();

        //Assert
        Assertions.assertThat(savedEmployee.getName()).isEqualTo("Harry");
    }

    @Test
    public void EmployeeRepository_Update_ReturnUpdatedEmployee() {
        Employee firstEmployee = new Employee(1L,"Frank","123hello","345@gmail.com","Tester");

        employeeRepository.save(firstEmployee);

        Employee savedEmployee = employeeRepository.findById(firstEmployee.getId()).get();
        savedEmployee.setRole("Developer");

        employeeRepository.save(savedEmployee);

        Employee updateEmployee = employeeRepository.findByRole("Developer").get();

        Assertions.assertThat(updateEmployee).isNotNull();
    }

    @Test
    public void EmployeeRepository_Delete_ReturnEmpty() {
        Employee employee = new Employee(1L, "Louis","345right","345@gmail.com", "Tester");

        employeeRepository.save(employee);

        employeeRepository.deleteById(employee.getId());
        Optional<Employee> deletedEmployee = employeeRepository.findById(employee.getId());

        Assertions.assertThat(deletedEmployee).isEmpty();
    }
}

