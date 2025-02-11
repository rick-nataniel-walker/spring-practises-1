/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.ems.services;

import com.walker_projects.ems.dtos.DepartmentDto;
import com.walker_projects.ems.entities.Department;
import com.walker_projects.ems.exceptions.ResourceNotFoundException;
import com.walker_projects.ems.mappers.DepartmentMapper;
import com.walker_projects.ems.repositories.DepartmentRepository;
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
public class DepartmentServiceEmpl implements DepartmentService{
    
    private DepartmentRepository depRepo;

    @Override
    public DepartmentDto getDeparmentById(Long depId) {
        Department dep = getDepartmentDto(depId);
        return DepartmentMapper.mapToDepartmentDto(dep);
    }

    @Override
    public DepartmentDto storeDepartment(DepartmentDto depDto) {
        Department dep = DepartmentMapper.mapToDepartment(depDto);
        return DepartmentMapper.mapToDepartmentDto(depRepo.save(dep));
    }

    @Override
    public List<DepartmentDto> getAllDepartmens() {
        List<Department> deps = depRepo.findAll();
        return deps.stream()
            .map((dep) -> DepartmentMapper.mapToDepartmentDto(dep))
            .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long depId, DepartmentDto depDto) {
        Department dep = getDepartmentDto(depId); 
        
        dep.setDepartmentName(depDto.getDepartmentName());
        dep.setDepartmentDescription(depDto.getDepartmentDescription());
        
        Department updatedDep = depRepo.save(dep);
        
        return DepartmentMapper.mapToDepartmentDto(updatedDep);
    }

    @Override
    public void deleteDepartment(Long depId) {
       Department depDto = getDepartmentDto(depId);
       depRepo.delete(depDto);
    }
    
    private Department getDepartmentDto(Long depId) throws ResourceNotFoundException{
        return depRepo.findById(depId).orElseThrow();
    }
    
}
