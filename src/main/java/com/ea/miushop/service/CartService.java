package com.ea.miushop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.Order;
import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.Cart;
@Service
public interface CartService {
    Cart getCart(Long id);
    Cart createCart(Cart cart);
    Cart updateCart(Cart cart);
    Cart addToCart(Item item, Long cartId);
	void checkOut(List<Item> items);
	void removeItem(Long itemId);
	List<Item> getAllItemsInCart(Long cartId);
	

}
