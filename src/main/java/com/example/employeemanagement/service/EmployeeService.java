package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));;
        return employee;
    }

    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Created";
    }

    public String deleteEmployee(int id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Id not found");
        }
        employeeRepository.deleteById(id);
        return "Deleted";

    }

    public String updateEmployee(Employee employee, int id) {
        Employee existData=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
        existData.setFirstname(employee.getFirstname());
        existData.setLastName(employee.getLastName());
        existData.setEmail(employee.getEmail());
        existData.setPhone(employee.getPhone());
        existData.setDesignation(employee.getDesignation());
        existData.setDepartment(employee.getDepartment());
        existData.setPhone(employee.getPhone());
        existData.setSalary(employee.getSalary());
        employeeRepository.save(existData);
        return "Updated";
    }
}
