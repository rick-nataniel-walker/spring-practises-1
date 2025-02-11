/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.ems.services;

import com.walker_projects.ems.dtos.EmployeeDto;
import com.walker_projects.ems.entities.Employee;
import com.walker_projects.ems.exceptions.ResourceNotFoundException;
import com.walker_projects.ems.mappers.EmployeeMapper;
import com.walker_projects.ems.repositories.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncossa
 */ 
@Service
@AllArgsConstructor
public class EmployeeServiceEmpl implements EmployeeService{
    
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exists"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
            .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
            .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
         Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exists"));
         
         employee.setFirstName(employeeDto.getFirstName());
         employee.setLastName(employeeDto.getLastName());
         employee.setEmail(employeeDto.getEmail());
         
         Employee updatedEmployee = employeeRepository.save(employee);
         
         return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public EmployeeDto deleteEmployee(Long employeeId) {
         Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exists"));
         
         employeeRepository.delete(employee);
         
         return EmployeeMapper.mapToEmployeeDto(employee);
    }

   
    
}
