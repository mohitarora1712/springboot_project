package com.lpu.emp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lpu.emp.entity.Product;
import com.lpu.emp.repository.ProductRepository;


@Service
public class ProductService {
	private ProductRepository repo;
	
	@Autowired
	public ProductService(ProductRepository repo) {
		super();
		this.repo=repo;
	}
	
	public List<Product> saveAllProduct(List<Product> products) {
		return repo.saveAll(products);
	}
	
	
	public List<Product> productPagination(int pNumber, int pSize) {
		Pageable pageable=PageRequest.of(pNumber, pSize);
		return repo.findAll(pageable).getContent();
	}
	
	public List<Product> sortedProducts(String fields) {
//		Pageable page = PageRequest.of(pageNumber, size);
		
		return repo.findAll(Sort.by(fields).descending());
	}
	
	public List<Product> sortProductPage(int pageNumber, int size, String field){
		Pageable pageable = PageRequest.of(pageNumber, size,Sort.by(field).descending());
		return repo.findAll(pageable).getContent();
	}
	

}
