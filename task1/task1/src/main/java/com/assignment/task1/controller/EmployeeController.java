package com.assignment.task1.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.task1.entity.Employee;
import com.assignment.task1.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	

	private final EmployeeService service ;
	
	public EmployeeController( EmployeeService  service) {
		this.service=service;
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> fetchAllEmployee() {
		return service.findAllEmployee();
	}
	
	@GetMapping("/employees/{id}")
	public Employee fetchById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@GetMapping("/employees/search/name")
	public List<Employee> getEmpByName(@RequestParam String name) {
		return service.getEmpByName(name);
	}
	
	@GetMapping("/employees/search/dept")
	public List<Employee> getEmpByDept(@RequestParam String dept) {
		return service.getEmpByDept(dept);
	}
	
	@GetMapping("/employees/search/phone")
	public List<Employee> getEmpByPhone(@RequestParam long phone) {
		return service.getEmpByPhone(phone);
	}
	
	@GetMapping("/employees/search/email")
	public List<Employee> getEmpByEmail(@RequestParam String email) {
		return service.getEmpByEmail(email);
	}
	
	@GetMapping("/employees/search/sal")
	public List<Employee> getEmpBySal(@RequestParam int sal) {
		return service.getEmpBySal(sal);
	}
	
	
	

}
