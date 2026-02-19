package com.alpha.FoodDeliveryExpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.FoodDeliveryExpress.dto.RestaurantReqDto;
import com.alpha.FoodDeliveryExpress.entity.Restaurant;
import com.alpha.FoodDeliveryExpress.repository.RestaurantRepository;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void adding(RestaurantReqDto restaurantReqDto) {

        Restaurant restaurant=new Restaurant();
        restaurant.setName(restaurantReqDto.getName());
        restaurant.setMobno(restaurantReqDto.getMobno());
        restaurant.setMailid(restaurantReqDto.getMailid());
        //error line
//        restaurant.setAddress(restaurantReqDto.getLocationCordinate());
        restaurant.setAddress(null);


        restaurant.setDescription(restaurantReqDto.getDescription());
        restaurant.setPackagingFees(restaurantReqDto.getPackagingFees());
        restaurant.setType(restaurantReqDto.getType());

        restaurantRepository.save(restaurant);

    }

    public void deleteRestaurant(long mobno) {
        Restaurant r=  restaurantRepository.findByMobno(mobno).orElseThrow(()->new RuntimeException("Restaurant not found"));
        restaurantRepository.delete(r);
  }

	public Restaurant findRestaurant(long mobno) {
		 return restaurantRepository.findByMobno(mobno).orElseThrow(()->new RuntimeException("Restaurant not found"));
    }
	}
    
    

    
    


