package com.alpha.FoodDeliveryExpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.FoodDeliveryExpress.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	  Optional<Customer> findByMobno(long mobno);



}
