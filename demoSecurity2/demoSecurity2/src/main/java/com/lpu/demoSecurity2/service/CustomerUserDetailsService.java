package com.lpu.demoSecurity2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.demoSecurity2.entity.Customer;
import com.lpu.demoSecurity2.repository.CustomerRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Customer customer=repo.findByName(username);
		return new CustomerUserDetails(customer);
	}

}
