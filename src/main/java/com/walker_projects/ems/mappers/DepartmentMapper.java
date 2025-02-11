/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.walker_projects.ems.mappers;

import com.walker_projects.ems.dtos.DepartmentDto;
import com.walker_projects.ems.entities.Department;

/**
 *
 * @author ncossa
 */
public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department dep) {
        return new DepartmentDto(
            dep.getId(),
            dep.getDepartmentName(),
            dep.getDepartmentDescription()
        );
       
    }
    public static Department mapToDepartment(DepartmentDto depDto) {
        return new Department(
            depDto.getId(),
            depDto.getDepartmentName(),
            depDto.getDepartmentDescription()
        );
    }
}
