package com.alpha.FoodDeliveryExpress.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.FoodDeliveryExpress.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	Optional<Address> findByStreet(String street);

}
