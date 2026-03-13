package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.product.entity.Products;
import com.product.service.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService serv;

	public ProductController(ProductService serv) {
		super();
		this.serv = serv;
	}
	
	@PostMapping("/save")
	public Products saveProduct(@RequestBody Products product) {
		return serv.saveProducts(product);
	}
	
	@GetMapping("/rt")
	public ResponseEntity<String> takeDataFromUser() {
		String url="http://localhost:8091/user/save";
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> response=template.exchange(url, HttpMethod.GET, null, String.class);
		return response;
	}
	
	@GetMapping("/get-product")
	public String getProducts() {
		return "products : Laptop, Mobile, Book";
	}

}
