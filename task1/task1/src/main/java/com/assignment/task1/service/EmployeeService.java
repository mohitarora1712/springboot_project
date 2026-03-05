package com.assignment.task1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.task1.entity.Employee;
import com.assignment.task1.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private final EmployeeRepository repository;
	
	public EmployeeService(EmployeeRepository repository) {
		this.repository=repository;
	}
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public List<Employee> findAllEmployee(){
		return repository.findAll();
	}
	
	public Employee findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public List<Employee> getEmpByName(String name) {
		return repository.getEmpByName(name);
	}
	
	public List<Employee> getEmpByDept(String dept) {
		return repository.getEmpByDept(dept);
	}
	
	public List<Employee> getEmpByPhone(long phone) {
		return repository.getEmpByPhone(phone);
	}
	
	public List<Employee> getEmpByEmail(String email) {
		return repository.getEmpByEmail(email);
	}
	public List<Employee> getEmpBySal(int sal) {
		return repository.getEmpBySal(sal);
	}
	

}
