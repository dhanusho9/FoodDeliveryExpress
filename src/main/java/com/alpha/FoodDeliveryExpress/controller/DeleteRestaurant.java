package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.service.RestaurantService;

@RestController
public class DeleteRestaurant {
	
	 @Autowired
	    private RestaurantService restaurantService;

	    @DeleteMapping("/delete/restaurant")
	    public void deleteRestaurant(@RequestParam long mobno){
	        restaurantService.deleteRestaurant(mobno);
	        
	    }


}
