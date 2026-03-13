package com.lpu.service.impl;

import org.springframework.stereotype.Service;
import com.lpu.client.BookClient;
import com.lpu.entity.Orders;
import com.lpu.repository.OrderRepository;
import com.lpu.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repo;
    private final BookClient client;

    public OrderServiceImpl(OrderRepository repo, BookClient client) {
        this.repo = repo;
        this.client = client;
    }

    public Orders place(Orders o) {
        var book = client.getBook(o.getBookId());
        o.setTotalPrice(book.getPrice() * o.getQuantity());
        o.setStatus("PLACED");
        return repo.save(o);
    }
}