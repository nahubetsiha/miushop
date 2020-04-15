package com.ea.miushop.controller;

import com.ea.miushop.domain.Cart;
import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.Order;
import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.StorageMovement;
import com.ea.miushop.service.CartService;
import com.ea.miushop.service.ItemService;
import com.ea.miushop.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	ItemService itemService;
	@Autowired
	private OrderController orderController;

	@GetMapping(value = "{cartId}")
	public Cart getCartById(@PathVariable Long cartId) {
		return cartService.getCart(cartId);
	}

	@GetMapping(value = "items/{cartId}")
	public List<Item> getAllItemsInCart(@PathVariable Long cartId) {
		return cartService.getAllItemsInCart(cartId);
	}

	@GetMapping(value = "itembyId/{cartId}/{itemId}")
	public Item getItem(@PathVariable Long cartId, @PathVariable Long itemId) {
		return cartService.getItem(cartId, itemId);
	}

	@PostMapping(value = "new-cart", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void createCart(@RequestBody Cart cart) {
		cartService.createCart(cart);
	}

	@PostMapping(value = "update-cart", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void updateCart(@RequestBody Cart cart) {
		cartService.createCart(cart);
	}

	@PostMapping(value = "add-item", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void addItem(@RequestBody Item item, Long cartId) {
		cartService.addToCart(item, cartId);
	}

	@PostMapping(value = "checkout", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void sendOrder(@RequestBody List<Item> items) {
		cartService.checkOut(items);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/delete/{itemId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void removeFromCart(@PathVariable("itemId") Long itemId) {
		cartService.removeItem(itemId);
	}

}
