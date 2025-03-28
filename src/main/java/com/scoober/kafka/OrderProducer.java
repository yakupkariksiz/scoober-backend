package com.scoober.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.scoober.model.Order;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderPlacedEvent(Order order) {
        kafkaTemplate.send("order_placed", order.getOrderId(), order);
        System.out.println("Published order_placed event for orderId: " + order.getOrderId());
    }
    
}
