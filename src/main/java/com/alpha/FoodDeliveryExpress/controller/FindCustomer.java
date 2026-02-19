package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.entity.Customer;
import com.alpha.FoodDeliveryExpress.service.CustomerService;

@RestController
public class FindCustomer {
	 @Autowired
	    private CustomerService customerService;

	    @GetMapping("/find/customer")
	    public ResponseEntity<Customer> findCustomer(@RequestParam long mobno){
	        Customer c=customerService.findCustomer(mobno);
	        return new ResponseEntity<>(c, HttpStatus.OK);
	    }

}
