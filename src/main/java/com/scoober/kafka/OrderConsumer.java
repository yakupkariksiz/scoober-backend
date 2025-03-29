package com.scoober.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.scoober.model.Order;
import com.scoober.service.CourierAssignmentService;

@Service
public class OrderConsumer {

    private final CourierAssignmentService courierAssignmentService;

    public OrderConsumer(CourierAssignmentService courierAssignmentService) {
        this.courierAssignmentService = courierAssignmentService;
    }

    @KafkaListener(topics = "order_placed", groupId = "scoober_group")
    public void consumeOrderPlaced(Order order) {
        System.out.println("Received order_placed event for orderId: " + order.getOrderId());
        courierAssignmentService.assignCourierToOrder(order);
    }
}
