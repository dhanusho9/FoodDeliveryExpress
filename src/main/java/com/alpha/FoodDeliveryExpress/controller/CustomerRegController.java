package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.dto.CustomerReqDto;
import com.alpha.FoodDeliveryExpress.service.CustomerService;

@RestController
public class CustomerRegController {
	
	    @Autowired
	    private CustomerService customerService;

	    @PostMapping("/customer/register")
	    public void customerdto(@RequestBody CustomerReqDto customerReqDto){
	       customerService.adding(customerReqDto);
	    }
}
