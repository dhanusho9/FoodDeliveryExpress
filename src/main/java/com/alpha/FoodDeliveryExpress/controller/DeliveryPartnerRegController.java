package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.dto.DeliveryPartnerDto;
import com.alpha.FoodDeliveryExpress.service.DeliveryPartnerService;

@RestController
public class DeliveryPartnerRegController {
	
	   @Autowired
	    private DeliveryPartnerService deliveryPartnerService;

	    @PostMapping("/deliveryPartner/register")
	    public void adding(@RequestBody DeliveryPartnerDto deliveryPartnerDto){
	        deliveryPartnerService.adding(deliveryPartnerDto);
	    }

}
