package com.ea.miushop.service.impl;

import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.Order;
import com.ea.miushop.service.CartService;
import com.ea.miushop.service.OrderService;
import com.ea.miushop.repository.CartRepository;
import com.ea.miushop.repository.OrderRepository;
import com.ea.miushop.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private OrderService orderService;

	@Override
	public Cart getCart(Long id) {
		return cartRepository.getOne(id);
	}

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart addToCart(Item item, Long cartId) {
		Cart cart = cartRepository.getOne(cartId);
		cart.addItem(item);
		return cartRepository.save(cart);
	}

	@Override
	public List<Item> getAllItemsInCart(Long cartId) {

		Cart cart = cartRepository.getOne(cartId);

		List<Item> itemList = cart.getItemList();

		return itemList;
	}

	@Override
	public void checkOut(List<Item> items) {
		Order order=new Order();
		order.setItems(items);
		orderService.makeOrder(order);
	}

	@Override
	public void removeItem(Long itemId) {
		Cart cart= new Cart();
		List<Item> items = cart.getItemList();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItemId() == itemId)
				items.remove(i);
		}
	}
}
