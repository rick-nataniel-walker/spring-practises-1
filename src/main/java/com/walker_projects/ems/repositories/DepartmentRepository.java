/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.walker_projects.ems.repositories;

import com.walker_projects.ems.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ncossa
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
