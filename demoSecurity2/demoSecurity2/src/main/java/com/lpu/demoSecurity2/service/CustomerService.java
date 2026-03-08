package com.lpu.demoSecurity2.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.demoSecurity2.entity.Customer;
import com.lpu.demoSecurity2.repository.CustomerRepo;

@Service
public class CustomerService {

	private final CustomerRepo repo;
	private final PasswordEncoder pe;

	public CustomerService(CustomerRepo repo, PasswordEncoder pe) {
		super();
		this.repo = repo;
		this.pe=pe;
	}
	
	public Customer register(Customer customer) {
		String encodePass=pe.encode(customer.getPassword());
		customer.setPassword(encodePass);
		return repo.save(customer);
	}
}
