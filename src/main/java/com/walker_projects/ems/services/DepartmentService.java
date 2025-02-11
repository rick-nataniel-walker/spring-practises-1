/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.walker_projects.ems.services;

import com.walker_projects.ems.dtos.DepartmentDto;
import java.util.List;

/**
 *
 * @author ncossa
 */
public interface DepartmentService {
    public DepartmentDto getDeparmentById(Long depId);
    public DepartmentDto storeDepartment(DepartmentDto depDto);
    public List<DepartmentDto> getAllDepartmens();
    public DepartmentDto updateDepartment(Long depId, DepartmentDto depDto);
    public void deleteDepartment(Long depId);
}
