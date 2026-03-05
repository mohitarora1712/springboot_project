package com.lpu.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.emp.entity.Company;
import com.lpu.emp.entity.Employee;
import com.lpu.emp.service.CompanyService;

import jakarta.validation.Valid;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService cs;
	
//	@PostMapping("/company")
//	public String saveComp(@RequestBody Company company) {
//		
//		cs.saveCompany(company);
//		return "saved";
//	}
	@PostMapping("/company")
	public ResponseEntity<Company> saveComp(@Valid @RequestBody Company company) {
		Company comp = cs.saveCompany(company);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(comp);
	}
	
	@PostMapping("/company2")
	public ResponseEntity<Company> saveCompMappedByEmployee(@RequestBody Company company) {
		
		Company comp = cs.saveCompanyAndMapWithComapny(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(comp);
	}
	
	@PostMapping("/company/{id}")
	public String saveNewEmployees(@PathVariable int id, @RequestBody List<Employee> newList) {
		cs.saveEmployeeToExistingCompany(id, newList);
		return "added new employees";
	}
	
	@GetMapping("/data/{num1}/{num2}")
	public String divide(@PathVariable int num1, @PathVariable int num2) {
		return "Result: "+num1/num2;
	}
	
	@GetMapping("/company/find{id}")
	public Company findEmp(@PathVariable int id) {
		return cs.findCompById(id);
	}
	
	

}
