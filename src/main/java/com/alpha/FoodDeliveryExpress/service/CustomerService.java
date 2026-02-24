package com.alpha.FoodDeliveryExpress.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.FoodDeliveryExpress.dto.CustAddressReqDto;
import com.alpha.FoodDeliveryExpress.dto.CustomerReqDto;
import com.alpha.FoodDeliveryExpress.entity.Address;
import com.alpha.FoodDeliveryExpress.entity.CartItem;
import com.alpha.FoodDeliveryExpress.entity.Customer;
import com.alpha.FoodDeliveryExpress.entity.Item;
import com.alpha.FoodDeliveryExpress.entity.Restaurant;
import com.alpha.FoodDeliveryExpress.repository.CartItemRepository;
import com.alpha.FoodDeliveryExpress.repository.CustomerRepository;
import com.alpha.FoodDeliveryExpress.repository.ItemRepository;


@Service
public class CustomerService {

	
	 @Autowired
	    private CustomerRepository customerRepository;
	 
	 @Autowired
	  private ItemRepository itemRepository;
	 
	 @Autowired
	    private CartItemRepository cartItemRepository;
	 
	  
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
		
		 public void addtocart(long mobno, int itemid, int quantity) {
		        Customer customer=customerRepository.findByMobno(mobno).orElseThrow(()->new RuntimeException("Customer not found"));
		       Item item =itemRepository.findById(itemid).orElseThrow(()->new RuntimeException("Item not found"));

		        CartItem c1=new CartItem();
		        c1.setQuantity(quantity);
		        c1.setItem(item);
		        c1.setCustomer(customer);
		        c1.setRestaurant(item.getRestaurant());
		        customer.getCartItems().add(c1);
		        cartItemRepository.save(c1);


		    }
	    
		 public Customer saveCustomer(CustomerReqDto dto) {

		        Customer customer = new Customer();
		        customer.setName(dto.getName());
		        customer.setMobno(dto.getMobno());
		        customer.setMailId(dto.getMailid());
		        customer.setGender(dto.getGender());

		        List<Address> addressList = new ArrayList<>();

		        for (CustAddressReqDto adto : dto.getAddresses()) {

		            Address address = new Address();
		            address.setFlatNumber(adto.getFlatNumber());
		            address.setBuildingName(adto.getBuildingName());
		            address.setStreet(adto.getStreet());
		            address.setCity(adto.getCity());
		            address.setState(adto.getState());
		            address.setPincode(adto.getPincode());
		            address.setAddressType(adto.getAddressType());
		            address.setDefault(adto.getDefault());

		            addressList.add(address);
		        }

		        customer.setAddress(addressList);

		        return customerRepository.save(customer);
		    }


		    public void addtocartt(long mobno, int itemid, int quantity) {

		        Customer customer = customerRepository.findByMobno(mobno)
		                .orElseThrow(() -> new RuntimeException("Customer not found"));

		        Item item = itemRepository.findById(itemid)
		                .orElseThrow(() -> new RuntimeException("Item not found"));

		        List<CartItem> cart = customer.getCartItems();

		        if (cart.isEmpty()) {

		            CartItem cartItem = new CartItem(item, quantity);
		            cartItem.setCustomer(customer);
		            cartItem.setRestaurant(item.getRestaurant());
		            cart.add(cartItem);

		        } else {

		            Restaurant existingRestaurant = cart.get(0).getRestaurant();
		            Restaurant newRestaurant = item.getRestaurant();

		            if (!(existingRestaurant.getId() == (newRestaurant.getId()))) {
		                throw new RuntimeException("Cannot add item from different restaurant");
		            }

		            // if item already present
		            Optional<CartItem> existingItem = cart.stream()
		                    .filter(ci -> ci.getItem().getId() == itemid)
		                    .findFirst();

		            if (existingItem.isPresent()) {

		                existingItem.get().setQuantity(
		                        existingItem.get().getQuantity() + quantity
		                );

		            } else {

		                CartItem cartItem = new CartItem(item, quantity);
		                cartItem.setCustomer(customer);
		                cartItem.setRestaurant(item.getRestaurant());
		                cart.add(cartItem);
		            }
		        }

		        customerRepository.save(customer);
		    }
	  
	   
}
