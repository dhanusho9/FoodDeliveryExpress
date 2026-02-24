package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.service.CustomerService;

@RestController
public class DeleteCustomer {

	  @Autowired
	    private CustomerService customerService;

		@DeleteMapping("/delete/customer")
	    public void deleteCustomer(@RequestParam long mobno){
	        customerService.deleteCustomer(mobno);

}
	    
}