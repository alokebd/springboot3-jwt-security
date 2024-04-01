package com.ait.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.tech.dto.OrderResponseDTO;
import com.ait.tech.service.DoorDashAppService;

@RestController
@RequestMapping("/doordash")
public class DoorDashAppController {

    @Autowired
    private DoorDashAppService service;

    @GetMapping("/home")
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO checkOrderStatus(@PathVariable String orderId) {
        return service.checkOrderStatus(orderId);
    }
    
    @GetMapping("/v1/{orderId}")
    public OrderResponseDTO findLiveOrderStatus(@PathVariable String orderId) {
    	System.out.println(">>DoorDashAppController - orderId:"+ orderId);
        return service.findLiveOrderStatus(orderId);
    }
}
