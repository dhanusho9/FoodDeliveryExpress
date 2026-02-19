package com.alpha.FoodDeliveryExpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.FoodDeliveryExpress.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	   Optional<Item> findByName(String name);	
	

}
