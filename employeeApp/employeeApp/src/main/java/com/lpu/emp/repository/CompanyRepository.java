package com.lpu.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.emp.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
}
