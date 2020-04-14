package com.ea.miushop_cart.service;

import java.math.BigDecimal;
import java.util.List;

import com.ea.miushop.domain.Product;
import com.ea.miushop_cart.model.Cart;
import com.ea.miushop_cart.model.OrderedItem;

public interface CartService {

	void updateItemQuantity(Product product, int quantity);
	void removeItem(String name);
	void clearItems();
	BigDecimal getTotalAmount();
	Cart getCart(Long id);
	Cart createCart(Cart cart);
	Cart updateCart(Cart cart);
	Boolean checkCartExists(Long id);
	List<Long> getAllProductIdsInACart(Long cartId);
	Cart addToCart(Product product, Long cartId);
	int getItemCount();
}
