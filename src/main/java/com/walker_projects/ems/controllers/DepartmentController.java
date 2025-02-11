/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.ems.controllers;

import com.walker_projects.ems.dtos.DepartmentDto;
import com.walker_projects.ems.services.DepartmentService;
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
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService depService;
    
    @PostMapping
    public ResponseEntity<DepartmentDto> createDep(@RequestBody DepartmentDto depDto) {
        DepartmentDto dep = depService.storeDepartment(depDto);
        return new ResponseEntity<>(dep, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getDepartments() {
        List<DepartmentDto> deps = depService.getAllDepartmens();
        return ResponseEntity.ok(deps);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable Long id) {
        DepartmentDto dep = depService.getDeparmentById(id);
        return ResponseEntity.ok(dep);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto depDto) {
        DepartmentDto dep = depService.updateDepartment(id, depDto);
        return ResponseEntity.ok(dep);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity deleteDepartment(@PathVariable Long id) {
        depService.deleteDepartment(id);
        return ResponseEntity.ok("Deleted succesfully");
    }
}
