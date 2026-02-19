package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.service.DeliveryPartnerService;

@RestController
public class DeleteDeliveryPartner {
	
	@Autowired
    private DeliveryPartnerService deliveryPartnerService;

    @DeleteMapping("/delete/deliveryPartner")
    public void deletePartner(@RequestParam long mobno){
        deliveryPartnerService.deletePartner(mobno);

    }

}
