package com.lpu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}