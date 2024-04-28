package com.tapfoods.dao;

import java.util.List;

import com.tapfoods.model.Restaurant;

public interface RestaurantDao {

	void addRestaurant(Restaurant restaurant);

	Restaurant getRestaurant(int restaurantId);

	List<Restaurant> getAllRestaurants();

	void updateRestaurant(Restaurant restaurant);

	void deleteRestaurant(int RestaurantId);
	
	List<Restaurant> getAllRestaurantsBySearch(String searchinput);

}
