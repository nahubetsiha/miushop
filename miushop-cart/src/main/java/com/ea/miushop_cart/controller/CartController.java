package com.ea.miushop_cart.controller;

import com.ea.miushop.domain.Product;
import com.ea.miushop_cart.*;
import com.ea.miushop_cart.model.Cart;
import com.ea.miushop_cart.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping(value = "{cartId}")
//	@GetMapping("/{cartId}")
	public Cart getCart(@PathVariable Long cartId) {
		return cartService.getCart(cartId);
	}

//	@PostMapping(value = "new-cart", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	@PostMapping("/create")
	public Cart createCart(Cart cart) {
		return cartService.createCart(cart);
	}
//	@Autowired
//	private RestTemplate restTemplate;
//
//	private String order_service_url = "http://order-service:8081/rest/order/";
//	private String product_service_url = "http://product-service:8084/rest/product/";
//
//	@PostMapping("/addToCart/{productId}/{quantity}/{cartId}")
//	public Cart addToCart(@PathVariable Long cartId, @PathVariable Long productId, @PathVariable int quantity,
//			Model model) {
//		OrderedItem orderLine = restTemplate.postForObject(
//				order_service_url + "/orderLine/create/" + productId + "/" + quantity, null, OrderLine.class);
//
//		com.ea.miushop.domain.Product product = new com.ea.miushop.domain.Product();
//		product.setProductId(orderLine.getProductId());
//		product.setQuantity(orderLine.getQuantity());
//
//		if (cartService.checkCartExists(cartId)) {
//			Cart cart = cartService.getCart(cartId);
//			cart.addItem(product);
//			System.out.println(cart.getOrderedItemList().get(1).getProduct().getProductId());
//			return cartService.updateCart(cart);
//		}
//
//		Cart cart = new Cart();
//		cart.addItem(product);
//		return cartService.createCart(cart);
//	}
//
//	@GetMapping("/getAllProducts/{id}")
//	public List<Product> getAllProductsInACart(@PathVariable Long id) {
//		// get a list of productId then call the product service and get a List of
//		// Products
//		List<Long> productIds = cartService.getAllProductIdsInACart(id);
//
//		return productIds.stream()
//				.map(productId -> restTemplate.getForObject(product_service_url + "/" + productId, Product.class))
//				.collect(Collectors.toList());
//	}
}