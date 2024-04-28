package com.tapfoods.dao;

import java.util.List;

import com.tapfoods.model.Menu;

public interface MenuDao {

	void addMenu(Menu menu);

	Menu getMenu(int menuId);

	List<Menu> getAllMenus();

	void updateMenu(Menu menu);

	void deleteMenu(int menuId);

	List<Menu> getByRestaurantId(int restaurantId);

	List<Menu> getAllBySearch(String input, int rid);

	List<Menu> getTopRatedItems(int restaurantId);

	List<Menu> getPriceLowToHigh(int restaurantId);

	List<Menu> getPriceHighToLow(int restaurantId);

	List<Menu> getOnlyVeg(int restaurantId);

	List<Menu> getOnlyNonVeg(int restaurantId);

}
