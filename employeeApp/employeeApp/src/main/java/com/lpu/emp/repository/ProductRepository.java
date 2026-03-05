package com.lpu.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.emp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
