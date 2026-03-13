package com.users.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.users.entity.ProductDTO;

@FeignClient("PRODUCT")
public interface ProductFeignClientService {
	
	@GetMapping("/product/get-product")
	public String getProducts();
	
	@PostMapping("/products/save")
//    ProductDTO saveProduct(ProductDTO product);
	public String saveProduct();
}
