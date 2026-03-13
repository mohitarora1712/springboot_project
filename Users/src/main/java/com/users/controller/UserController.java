package com.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;
import com.users.entity.ProductDTO;
import com.users.entity.Users;
import com.users.service.ProductFeignClientService;
import com.users.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductFeignClientService productService;
	
	@GetMapping("/products")
	public String getProductInUser() {
		return productService.getProducts();
	}
	@Autowired
	private UserService serv;

	public UserController(UserService serv) {
		super();
		this.serv = serv;
	}
	
	@PostMapping("/save")
	public Users saveUser(@RequestBody Users user) {
		return serv.saveUser(user);
	}
	
	@GetMapping("/get/{id}")
	public Users findById(@PathVariable int id) {
		return serv.findById(id);
	}
	
	@GetMapping("/hi")
	public String getHi() {
		return "Hi";
	}
	
	@GetMapping("/hello")
	public String getHello() {
		System.err.println("Error");
		return"Hello";
	}
	
	@GetMapping("/data")
	public String getData() {
		return "Data";
	}
	
	 @PostMapping("/product")
	    public ProductDTO createProduct(@RequestBody ProductDTO dto){
	        return serv.createProduct(dto);
	    }

}
