package com.lpu.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
