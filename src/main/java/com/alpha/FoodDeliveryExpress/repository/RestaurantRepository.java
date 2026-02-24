package com.alpha.FoodDeliveryExpress.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.FoodDeliveryExpress.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	Optional<Restaurant> findByMobno(long mobno);
//	Optional<List<Restaurant>> findByAddress_City(String city);

	Optional<List<Restaurant>> findByAddress_City(String city);

}
