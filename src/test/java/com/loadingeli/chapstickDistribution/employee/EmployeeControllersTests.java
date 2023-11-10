package com.loadingeli.chapstickDistribution.employee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = EmployeeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class EmployeeControllersTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Employee> employees = new ArrayList<>();


    @Test
    public void EmployeeController_GetAllEmployees_ReturnAllEmployees() throws Exception {
        employees.add(0, new Employee(1L,"Joan", "Operator"));
        employees.add(1, new Employee(2L,"Justin", "Operator"));
        employees.add(2, new Employee(3L,"Joshua", "Foreman"));



        when(employeeService.getAllEmployees()).thenReturn(employees);

        ResultActions response = mockMvc.perform(get("/api/v1/employee/all")
                .contentType(MediaType.APPLICATION_JSON));

        Assertions.assertThat(response).isNotNull();
    }
}
