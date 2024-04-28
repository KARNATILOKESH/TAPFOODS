package com.tapfoods.dao;

import java.util.List;

import com.tapfoods.model.CartItem;

public interface CartDao {
	
	void addCart(CartItem cart);

	CartItem getCart(int cartId);

	List<CartItem> getAllCart();

	void updateCart(CartItem  cart);

	void deleteCart(int cartId);
	
	void truncateCart();
	
	int updateQuantity(String itemName,int quantity);
	
	CartItem getCartByItemName(String itemName);

	int updateQuantity(int id, int quantity);
	
	
	

}
