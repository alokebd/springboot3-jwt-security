package com.ait.tech.client;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.ait.tech.dto.OrderResponseDTO;

@Component
public class RestaurantServiceClient {
    @Autowired
    private RestTemplate template;

    public OrderResponseDTO fetchOrderStatus(String orderId) {
        return template.getForObject("http://RESTAURANT-SERVICE/restaurant/orders/status/" + orderId, OrderResponseDTO.class);
    }
    
    public OrderResponseDTO fetchLiveOrderStatus(String orderId) {
    	String url = "http://RESTAURANT-SERVICE/restaurant/orders/v1/status/".concat(orderId);
    	OrderResponseDTO orderResponseDTO = null;
    	try {
    		orderResponseDTO= template.getForObject(url, OrderResponseDTO.class);
    	}
    	catch(RestClientResponseException e) {
    		e.printStackTrace();
    	}
    	return orderResponseDTO;
    }
}
