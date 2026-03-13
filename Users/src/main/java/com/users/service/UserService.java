package com.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.entity.ProductDTO;
import com.users.entity.Users;
import com.users.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo; 
	
	@Autowired
    private ProductFeignClientService productClient;

	
	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}

	public Users saveUser(Users user) {
		return repo.save(user);
	}
	
	public Users findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	 public ProductDTO createProduct(ProductDTO dto){
	        return productClient.saveProduct(dto);
	    }

}
