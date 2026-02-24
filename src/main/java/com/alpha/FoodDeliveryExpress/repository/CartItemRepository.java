package com.alpha.FoodDeliveryExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.FoodDeliveryExpress.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
