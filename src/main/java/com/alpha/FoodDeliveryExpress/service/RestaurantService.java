package com.alpha.FoodDeliveryExpress.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alpha.FoodDeliveryExpress.dto.RestaurantReqDto;
import com.alpha.FoodDeliveryExpress.entity.Address;
import com.alpha.FoodDeliveryExpress.entity.Customer;
import com.alpha.FoodDeliveryExpress.entity.Item;
import com.alpha.FoodDeliveryExpress.entity.Restaurant;
import com.alpha.FoodDeliveryExpress.repository.AddressRepository;
import com.alpha.FoodDeliveryExpress.repository.CustomerRepository;
import com.alpha.FoodDeliveryExpress.repository.ItemRepository;
import com.alpha.FoodDeliveryExpress.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public void adding(RestaurantReqDto restaurantReqDto) {

		Restaurant restaurant = new Restaurant();
		restaurant.setName(restaurantReqDto.getName());
		restaurant.setMobno(restaurantReqDto.getMobno());
		restaurant.setMailid(restaurantReqDto.getMailid());
		// error line
//        restaurant.setAddress(restaurantReqDto.getLocationCordinate());

		// get the address from api by passing the location coordinates

		Address address = new Address();
		Map response = restTemplate
				.getForObject("https://us1.locationiq.com/v1/reverse?key=pk.5038d98b114a8653a2d8716f69a70c50" + "&lat="
						+ restaurantReqDto.getLocationCordinate().getLatitude() + "&lon="
						+ restaurantReqDto.getLocationCordinate().getLongitute() + "&format=json", Map.class);

		Map add = (Map) response.get("address");

		String city = (String) add.get("city");

		address.setCity(city);
		address.setCountry((String) add.get("country"));
		address.setPincode((String) add.get("postcode"));
		address.setState((String) add.get("state"));

		restaurant.setAddress(address);
		restaurant.setDescription(restaurantReqDto.getDescription());
		restaurant.setPackagingFees(restaurantReqDto.getPackagingFees());
		restaurant.setType(restaurantReqDto.getType());
		restaurant.setStatus("closed");

		restaurantRepository.save(restaurant);

	}

	public void deleteRestaurant(long mobno) {
		Restaurant r = restaurantRepository.findByMobno(mobno)
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));
		restaurantRepository.delete(r);
	}

	public Restaurant findRestaurant(long mobno) {
		return restaurantRepository.findByMobno(mobno).orElseThrow(() -> new RuntimeException("Restaurant not found"));
	}

	public Restaurant addtomenu(Item item, long mobno) {
		Restaurant restaurant = restaurantRepository.findByMobno(mobno)
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));
		restaurant.getMenu().add(item);
		item.setRestaurant(restaurant);
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	public void updateStatus(long mobno) {
		Restaurant restaurant = restaurantRepository.findByMobno(mobno)
				.orElseThrow(() -> new RuntimeException("restaurant not found"));
		if (restaurant.getStatus().equals("closed"))
			restaurant.setStatus("open");
		else if (restaurant.getStatus().equals("open"))
			restaurant.setStatus("closed");
		restaurantRepository.save(restaurant);

	}

	public void updateItemAvailability(long mobno, int itemid) {
		Restaurant restaurant = restaurantRepository.findByMobno(mobno)
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));
		Item item = itemRepository.findById(itemid).orElseThrow(() -> new RuntimeException("Item not found"));

		if (item.getAvailability().equals("Available"))
			item.setAvailability("Not Available");
		else if (item.getAvailability().equals("Not Available"))
			item.setAvailability("Available");

		itemRepository.save(item);
	}

	public List<Restaurant> searchItemOrRestaurant(long mobno, String searchKey) {

		Customer cust = customerRepository.findByMobno(mobno)
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		String city = cust.getAddress().getCity();

		List<Restaurant> restaurants = restaurantRepository.findByAddress_City(city).orElseThrow();
//
//		 restaurants.stream().filter(r -> r.getMenu().stream()
//				.anyMatch(menu -> menu.getName().toLowerCase().contains(searchKey.toLowerCase()))).toList();

		return restaurants.stream().filter(r -> r.getName().toLowerCase().contains(searchKey.toLowerCase())
				|| r.getMenu().stream().anyMatch(i -> i.getName().toLowerCase().contains(searchKey.toLowerCase())))
				.toList();
	}
}
