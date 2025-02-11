/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.ems.controllers;

import com.walker_projects.ems.dtos.EmployeeDto;
import com.walker_projects.ems.services.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ncossa
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    private EmployeeService employeeService;
    
    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        
    }
    
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    
    
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<EmployeeDto> employees = employeeService.getEmployees();
        return ResponseEntity.ok(employees);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(updatedEmployeeDto);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long id) {
        EmployeeDto deletedEmployee = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(deletedEmployee);
    }
    
}
