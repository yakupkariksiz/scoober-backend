package com.scoober.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scoober.model.Courier;
import com.scoober.model.Location;
import com.scoober.model.Order;
import com.scoober.repository.CourierRepository;
import com.scoober.repository.OrderRepository;
import com.scoober.util.ETAUtil;

@Service
public class CourierAssignmentService {
    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;

    public CourierAssignmentService(OrderRepository orderRepository, CourierRepository courierRepository) {
        this.orderRepository = orderRepository;
        this.courierRepository = courierRepository;   
    }

    public void assignCourierToOrder(Order order) {
        List<Courier> couriers = courierRepository.findAll();

        if (couriers.isEmpty()) {
            System.out.println("No available couriers to assign");
            return;
        }

        // Find the closest courier
        Optional<Courier> closestCourier = couriers.stream()
            .min(
                Comparator.comparingInt(courier -> 
                    ETAUtil.estimateEtaMinutes(
                        order.getLocation(), 
                        new Location(courier.getLatitude(), courier.getLongitude())
                    )
                )
            );

        if (closestCourier.isPresent()) {
            Courier courier = closestCourier.get();
            int etaMinutes = ETAUtil.estimateEtaMinutes(
                order.getLocation(), 
                new com.scoober.model.Location(courier.getLatitude(), courier.getLongitude()));

            // Update order with courier assignment
            order.setCourierId(courier.getId());
            order.setStatus("ASSIGNED");
            order.setEtaMinutes(etaMinutes);

            orderRepository.save(order);

            System.out.println("Assigned courier " + courier.getName() 
                + " to order " + order.getOrderId() 
                + ", ETA: " + etaMinutes + " minutes.");
        } else {
            System.out.println("Could not find a suitable courier.");
        }
    }
}
