/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.walker_projects.ems.services;

import com.walker_projects.ems.dtos.EmployeeDto;
import java.util.List;

/**
 *
 * @author ncossa
 */
public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    
    public EmployeeDto getEmployeeById(Long emploeeId);
    
    public List<EmployeeDto> getEmployees();
    
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
    
    public EmployeeDto deleteEmployee(Long employeeId);
}
