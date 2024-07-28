package com.loadingeli.chapstickDistribution.employee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreateEmployeeTests {

    @Test
    public void createEmployeeTest() {
        Employee firstEmployee = new Employee(1l,"john","123peace","345@gmail.com",0, "Designer");
        assertEquals("john", firstEmployee.getName());
        assertEquals("Designer", firstEmployee.getRole());
    }

    @Test
    public void changeEmployeeName() {

    }


}
