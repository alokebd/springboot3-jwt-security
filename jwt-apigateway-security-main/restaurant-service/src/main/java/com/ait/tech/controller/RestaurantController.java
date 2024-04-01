package com.ait.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.tech.dto.OrderResponseDTO;
import com.ait.tech.entity.RestaurantOrder;
import com.ait.tech.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/orders/status/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable String orderId) {
        return service.getOrder(orderId);
    }
    
    @PostMapping("/orders/v1")
    public String placeOrder(@RequestBody RestaurantOrder restaurantOrder) {
    	return service.saveOrder(restaurantOrder);
    }
    
    @GetMapping("/orders/v1/status/{orderId}")
    public OrderResponseDTO getOrderStatus(@PathVariable String orderId) {
    	System.out.println(">>>>>>>>>>orderId:".concat(orderId));
        return service.getOrderStatus(orderId);
    }
}
