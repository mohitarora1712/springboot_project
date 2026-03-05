package com.lpu.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.emp.entity.Company;
import com.lpu.emp.entity.Employee;

import com.lpu.emp.exception.CompanyIdNotFoundException;
import com.lpu.emp.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository cr;
	
	public Company saveCompany(Company company) {
		return cr.save(company);
	}
	
	public Company findCompById(int id) {
		return cr.findById(id).orElseThrow(()->new CompanyIdNotFoundException("Company "+id+" is not available"));
		
	}
	
	public void deleteById(int id) {
		Company emp = findCompById(id);
		
		cr.delete(emp);
	}
	
	public Company saveCompanyAndMapWithComapny(Company company) {
		 company.getEmployees().forEach((emp)-> emp.setCompany(company));
		 
		 return cr.save(company);
	}
	
	public Company saveEmployeeToExistingCompany(int compId, List<Employee> newEmp) {
		Company company = findCompById(compId);
		
		company.getEmployees().addAll(newEmp);
		return saveCompanyAndMapWithComapny(company);
	}

}
