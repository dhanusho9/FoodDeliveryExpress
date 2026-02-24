package com.alpha.FoodDeliveryExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.FoodDeliveryExpress.service.CustomerService;

@RestController
public class AddToCartCust {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/customer/addtocart")
    public ResponseEntity<String> addtocart(@RequestParam long mobno,@RequestParam int Itemid,@RequestParam int quantity){
        customerService.addtocart(mobno,Itemid,quantity);
        return new ResponseEntity<>("Added To Cart", HttpStatus.OK);
    }

}
