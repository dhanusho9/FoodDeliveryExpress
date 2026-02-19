package com.alpha.FoodDeliveryExpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.FoodDeliveryExpress.dto.CustomerReqDto;
import com.alpha.FoodDeliveryExpress.entity.Customer;
import com.alpha.FoodDeliveryExpress.repository.CustomerRepository;

@Service
public class CustomerService {

	
	 @Autowired
	    private CustomerRepository customerRepository;

	    public void adding(CustomerReqDto customerReqDto) {
	        Customer customer = new Customer();
	         customer.setName(customerReqDto.getName());
	         customer.setMobno(customerReqDto.getMobno());
	         customer.setMailid(customerReqDto.getMailid());
	         customer.setGender(customerReqDto.getGender());
	         customerRepository.save(customer);
	    }

		public void deleteCustomer(long mobno) {
			  Customer c= customerRepository.findByMobno(mobno).orElseThrow(()->new RuntimeException("Customer not found"));
		       customerRepository.delete(c);

		}

		public Customer findCustomer(long mobno) {
			
			 return  customerRepository.findByMobno(mobno).orElseThrow(()->new RuntimeException("Customer not found"));
		}
	    
	  
	   
}
