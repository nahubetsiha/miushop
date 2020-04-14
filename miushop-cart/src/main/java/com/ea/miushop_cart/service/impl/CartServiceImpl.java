package com.ea.miushop_cart.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ea.miushop.domain.Order;
import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.User;
import com.ea.miushop.repository.OrderRepository;
import com.ea.miushop_cart.model.Cart;
import com.ea.miushop_cart.model.OrderedItem;
import com.ea.miushop_cart.repository.CartRepository;
import com.ea.miushop_cart.service.CartService;

public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;
	List<OrderedItem> items = new ArrayList<>();

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
	public Boolean checkCartExists(Long id) {
		return cartRepository.existsById(id);
	}

	@Override
	public Cart addToCart(Product product, Long cartId) {
		Cart cart = cartRepository.getOne(cartId);
		cart.addItem(product);
		return cartRepository.save(cart);
	}

	@Override
	public List<Long> getAllProductIdsInACart(Long cartId) {

		Cart cart = cartRepository.getOne(cartId);

		List<Long> productIdList = new ArrayList<>();
		for (OrderedItem orderedItem : cart.getOrderedItemList()) {
			productIdList.add(orderedItem.getProduct().getProductId());
		}

		return productIdList;
	}

	@Override
	public void updateItemQuantity(Product product, int quantity) {
		for (OrderedItem lineItem : items) {
			if (lineItem.getProduct().getProductName().equals(product.getProductName())) {
				lineItem.setQuantity(quantity);
			}
		}
	}

	public void removeItem(String name) {
		OrderedItem item = null;
		for (OrderedItem lineItem : items) {
			if (lineItem.getProduct().getProductName().equals(name)) {
				item = lineItem;
				break;
			}
		}
		if (item != null) {
			items.remove(item);
		}
	}

	public void clearItems() {
		items = new ArrayList<OrderedItem>();
	}

	public int getItemCount() {
		int count = 0;
		for (OrderedItem lineItem : items) {
			count += lineItem.getQuantity();
		}
		return count;
	}

	public BigDecimal getTotalAmount() {
		BigDecimal amount = new BigDecimal("0.0");
		for (OrderedItem lineItem : items) {
			amount = amount.add(lineItem.getSubTotal());
		}
		return amount;
	}

}
