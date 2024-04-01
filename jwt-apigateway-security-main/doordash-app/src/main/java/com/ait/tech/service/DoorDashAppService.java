package com.ait.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.tech.client.RestaurantServiceClient;
import com.ait.tech.dto.OrderResponseDTO;

@Service
public class DoorDashAppService {

    @Autowired
    private RestaurantServiceClient restaurantServiceClient;

    public String greeting() {
        return "Welcome to Swiggy App Service";
    }

    public OrderResponseDTO checkOrderStatus(String orderId) {
        return restaurantServiceClient.fetchOrderStatus(orderId);
    }
    
    public OrderResponseDTO findLiveOrderStatus(String orderId) {
        return restaurantServiceClient.fetchLiveOrderStatus(orderId);
    }
}
