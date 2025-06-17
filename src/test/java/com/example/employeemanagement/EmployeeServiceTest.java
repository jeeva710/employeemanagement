package com.example.employeemanagement;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;
    Employee emp1 = new Employee(
            1,
            "Jeeva",
            "R",
            "jeeva.r@example.com",
            "9876543210",
            "Software Engineer",
            "IT",
            75000.00
    );
    Employee emp2 = new Employee(
            2,
            "Aadhi",
            "K",
            "aadhi.k@example.com",
            "9123456789",
            "QA Analyst",
            "Quality Assurance",
            65000.00
    );
    List<Employee> employeeListMock = new ArrayList<>(Arrays.asList(emp1, emp2));

    @Test
    void testGetAllEmployee() {


        when(employeeRepository.findAll()).thenReturn(employeeListMock);
        List<Employee> result = employeeService.getAllEmployees();
        result=null;
        assertNotNull(result);

        verify(employeeRepository, times(1)).findAll();


    }


}
