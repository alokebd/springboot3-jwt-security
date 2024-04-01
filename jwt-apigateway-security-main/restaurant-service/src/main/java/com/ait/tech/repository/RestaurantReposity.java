package com.ait.tech.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.tech.entity.RestaurantOrder;

public interface RestaurantReposity extends JpaRepository<RestaurantOrder, Integer>{
	Optional<RestaurantOrder> findByOrderId(String orderId);
}
