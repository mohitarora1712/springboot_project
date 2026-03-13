package com.lpu.controller;

import org.springframework.web.bind.annotation.*;
import com.lpu.entity.Orders;
import com.lpu.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Orders place(@RequestBody Orders o) {
        return service.place(o);
    }
}