package com.lpu.emp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.emp.dto.EmployeeDTO;
import com.lpu.emp.entity.Employee;
import com.lpu.emp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee>  saveEmp(@Valid @RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(es.saveEmployee(employee));
		
	}
	
	@PostMapping("/employee/{id}")
	public ResponseEntity<Employee>  updateEmp(@Valid @PathVariable int id, @RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(es.updateEmployee(id,employee));
		
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmp(@Valid  @PathVariable int id) {
		return es.findEmpById(id);
		
	}
	
}
