package com.tapfoods.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CartMap {

	private static Map<Integer, CartItem> CartItemMap;

	public CartMap() {
		CartItemMap = new LinkedHashMap<Integer, CartItem>();
	}

	public void addCartItem(CartItem cartitem, int rid) {
		int restaurantId = 0;
		Map<Integer, CartItem> allItems = getAllItems();
		Set<Integer> keySet = allItems.keySet();
		for (Integer key : keySet) {
			CartItem cartItem2 = CartItemMap.get(key);
			restaurantId = cartItem2.getRestaurantId();

		}

		if (rid == restaurantId) {
			if (CartItemMap.containsKey(cartitem.getItemId())) {
				int quantity = CartItemMap.get(cartitem.getItemId()).getQuantity();
				cartitem.setQuantity(quantity + 1);

				CartItemMap.put(cartitem.getItemId(), cartitem);
			} else {
				CartItemMap.put(cartitem.getItemId(), cartitem);
			}

		} else {
			CartItemMap.clear();
			CartItemMap.put(cartitem.getItemId(), cartitem);
		}

	}

	public void addQuantity(CartItem cartitem) {

		if (CartItemMap.containsKey(cartitem.getItemId())) {
			int quantity = CartItemMap.get(cartitem.getItemId()).getQuantity();
			cartitem.setQuantity(quantity + 1);

			CartItemMap.put(cartitem.getItemId(), cartitem);
		}

	}

	public void lessQuantity(CartItem cartitem) {

		if (CartItemMap.containsKey(cartitem.getItemId())) {
			int quantity = CartItemMap.get(cartitem.getItemId()).getQuantity();
			if (quantity > 1) {
				cartitem.setQuantity(quantity - 1);

				CartItemMap.put(cartitem.getItemId(), cartitem);
			}
		}

	}

	public static void removeCartItem(int itemId) {
		CartItemMap.remove(itemId);

	}

	public static Map<Integer, CartItem> getAllItems() {

		return CartItemMap;
	}
	
	public static void clear()
	{
		CartItemMap.clear();
	
	}
}
