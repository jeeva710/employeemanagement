package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }
    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable int id){
        return service.updateEmployee(employee,id);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

}
