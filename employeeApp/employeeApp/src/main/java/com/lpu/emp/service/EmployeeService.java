package com.lpu.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.emp.dto.EmployeeDTO;
import com.lpu.emp.entity.Company;
import com.lpu.emp.entity.Employee;
import com.lpu.emp.repository.CompanyRepository;
import com.lpu.emp.repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository er;
	@CachePut(value="employee", key="#result.id")
	public Employee saveEmployee(Employee employee) {
	    System.err.println("Saved in DB");
	    return er.save(employee);
	}
	
	@CachePut(value = "employee", key = "#id")
	public Employee updateEmployee(int id, Employee updatedEmployee) {

	    Employee existingEmployee = er.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    existingEmployee.setName(updatedEmployee.getName());
	    existingEmployee.setEmail(updatedEmployee.getEmail());
	    existingEmployee.setPhone(updatedEmployee.getPhone());
	    
	    System.err.println("Updated in DB");

	    return er.save(existingEmployee);
	}
	
	@Cacheable(value="employee" , key="#id")
	public Employee findEmpById(int id) {
		System.err.println("Fetching from DB");
		return  er.findById(id).orElse(null);
	}
	
	@CacheEvict(value="employee", key="#id")
	public void deleteById(int id) {
		Employee emp = findEmpById(id);
		
		er.delete(emp);
	}
	
	public EmployeeDTO entityToDTO(Employee employee) {
		EmployeeDTO empDTO = new EmployeeDTO();
		
		empDTO.setEmail(employee.getEmail());
		empDTO.setName(employee.getName());
		empDTO.setPhone(employee.getPhone());
		empDTO.setAge(employee.getAge());
		
		return empDTO;
		
	}
	
	public Employee DTOtoEntity(EmployeeDTO empDto) {
		
		Employee emp = new Employee();
		
		emp.setAge(empDto.getAge());
		emp.setName(empDto.getName());
		emp.setPhone(empDto.getPhone());
		emp.setEmail(empDto.getEmail());
		
		return emp;
	}
}
