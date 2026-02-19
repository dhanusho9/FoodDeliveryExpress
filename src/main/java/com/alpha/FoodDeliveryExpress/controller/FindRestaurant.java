package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.entity.Restaurant;
import com.alpha.FoodDeliveryExpress.service.RestaurantService;

@RestController
public class FindRestaurant {
	
	@Autowired
    private RestaurantService restaurantService;

    @GetMapping("/find/restaurant")
    public ResponseEntity<Restaurant> findRestaurant(@RequestParam long mobno){
        Restaurant r=restaurantService.findRestaurant(mobno);

        return new ResponseEntity<>(r, HttpStatus.OK);

    }

}
