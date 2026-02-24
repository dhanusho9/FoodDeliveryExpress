package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.dto.RestaurantReqDto;
import com.alpha.FoodDeliveryExpress.service.RestaurantService;

@RestController
public class RestaurantRegController {


    @Autowired
    private RestaurantService restaurantService;

	@PostMapping("/restaurant/register")
    private void adding(@RequestBody RestaurantReqDto restaurantReqDto){

        restaurantService.adding(restaurantReqDto);
    }
}
