package com.scoober.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scoober.kafka.OrderProducer;
import com.scoober.model.Order;
import com.scoober.repository.OrderRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
   
    private final OrderRepository orderRepo;
    private final OrderProducer orderProducer;

    public OrderController(OrderRepository orderRepo, OrderProducer orderProducer) {
        this.orderRepo = orderRepo;
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public Order postMethodName(@RequestBody Order order) {
        order.setStatus("PLACED");
        Order saved = orderRepo.save(order);
        orderProducer.sendOrderPlacedEvent(saved);
        return saved;
    }
}
