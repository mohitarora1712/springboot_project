package com.lpu.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.emp.entity.Product;
import com.lpu.emp.service.ProductService;

@RestController
@RequestMapping("/products") 
public class ProductController {
	@Autowired
	private ProductService serv;
	
	@PostMapping("/saveAll")
	public List<Product> saveAllPro(@RequestBody List<Product> list) {
		return serv.saveAllProduct(list);
	}
	
	@GetMapping("/page/{pNumber}/{pSize}")
	public List<Product> productPage(@PathVariable int pNumber, @PathVariable int pSize) {
		return serv.productPagination(pNumber, pSize);
	}
	
	@GetMapping("/page/{field}")
	public List<Product> getSomeProducts(@PathVariable String field){
		return serv.sortedProducts(field);
	}
	
	@GetMapping("/page/{pNumber}/{pSize}/{field}")
	public List<Product> sortProduct(@PathVariable int pNumber, @PathVariable int pSize, @PathVariable String field){
		return serv.sortProductPage(pNumber, pSize, field);
	}
}
