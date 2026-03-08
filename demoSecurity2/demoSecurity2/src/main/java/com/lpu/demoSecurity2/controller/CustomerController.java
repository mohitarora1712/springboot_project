package com.lpu.demoSecurity2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demoSecurity2.entity.Customer;
import com.lpu.demoSecurity2.service.CustomerService;

//@CrossOrigin(origins =  "")
@RestController
public class CustomerController {

	private final CustomerService serv;

	public CustomerController(CustomerService serv) {
		super();
		this.serv = serv;
	}
	
	@PostMapping("/register")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return serv.register(customer);
	}
	
	@GetMapping("/public")
	public String homePage() {
		return "Public Page";
	}
	
	@GetMapping("/account")
	public String account() {
		return "Account";
	}
	
	
}
