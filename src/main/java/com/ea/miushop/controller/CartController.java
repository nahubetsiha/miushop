package com.ea.miushop.controller;

import com.ea.miushop.domain.Cart;
import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.Order;
import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.StorageMovement;
import com.ea.miushop.service.CartService;
import com.ea.miushop.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	CartService cartService;

	@GetMapping(value = "{cartId}")
	public Cart getCartById(@PathVariable Long cartId) {
		return cartService.getCart(cartId);
	}

	@GetMapping(value = "items/{cartId}")
	public List<Item> getAllProductsID(@PathVariable Long cartId) {
		return cartService.getAllItemsInCart(cartId);
	}

	@PostMapping(value = "new-cart", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void createCart(Cart cart) {
		cartService.createCart(cart);
	}

	@PostMapping(value = "update-cart", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void updateCart(Cart cart) {
		cartService.createCart(cart);
	}

	@PostMapping(value = "add-item", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void addItem(Item item, Long cartId) {
		cartService.addToCart(item, cartId);
	}

	@PostMapping(value = "checkout", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void sendOrder(List<Item> items) {
		cartService.checkOut(items);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/cart/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void removeFromCart(@PathVariable("itemId") Long itemId) {
		cartService.removeItem(itemId);
	}

}
