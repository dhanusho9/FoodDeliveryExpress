package com.alpha.FoodDeliveryExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.FoodDeliveryExpress.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
