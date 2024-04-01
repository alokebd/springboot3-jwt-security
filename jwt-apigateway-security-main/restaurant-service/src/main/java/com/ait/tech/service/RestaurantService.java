package com.ait.tech.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.tech.dao.RestaurantOrderDAO;
import com.ait.tech.dto.OrderResponseDTO;
import com.ait.tech.entity.RestaurantOrder;
import com.ait.tech.repository.RestaurantReposity;
import org.modelmapper.ModelMapper;
@Service
public class RestaurantService {
    @Autowired
    private RestaurantOrderDAO orderDAO;
    
    @Autowired
    private RestaurantReposity restaurantReposity;
    

    public String greeting() {
        return "Welcome to Swiggy Restaurant service";
    }

    public OrderResponseDTO getOrder(String orderId) {
        return orderDAO.getOrders(orderId);
    }
    
    public String saveOrder(RestaurantOrder restaurantOrder) {
       	Optional<RestaurantOrder> restaurantOrderDb=restaurantReposity.findByOrderId(restaurantOrder.getOrderId());
    	String orderStatus = "Error";
       	if (!restaurantOrderDb.isPresent())	{
    		restaurantReposity.save(restaurantOrder);
    		orderStatus =restaurantOrder.getOrderId().concat(" order placed.");
    	}
       	else {
       		orderStatus= "Order already present";
       	}
    	return orderStatus;
    }
    
    public OrderResponseDTO getOrderStatus(String orderId) {
    	Optional<RestaurantOrder> restaurantOrderDb=restaurantReposity.findByOrderId(orderId);
    	ModelMapper modelMapper = new ModelMapper();
    	OrderResponseDTO orderResponseDTO = modelMapper.map(restaurantOrderDb, OrderResponseDTO.class);
        return orderResponseDTO;
    }
    
    
}
