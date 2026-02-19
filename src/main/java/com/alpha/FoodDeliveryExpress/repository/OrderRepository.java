package com.alpha.FoodDeliveryExpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.FoodDeliveryExpress.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	  Optional<Order> findByOtp(String otp);

}
