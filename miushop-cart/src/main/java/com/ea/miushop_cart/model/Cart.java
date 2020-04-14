package com.ea.miushop_cart.model;

import javax.persistence.*;
import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.User;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	User user;

	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderedItem> itemList = new ArrayList<>();

	public Cart() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderedItem> getOrderedItemList() {
		return itemList;
	}

	public void setOrderedItemList(List<OrderedItem> orderedItemList) {
		this.itemList = orderedItemList;
	}

	public void addItem(Product product) {

		for (OrderedItem item : itemList) {
			if (item.getProduct().getProductName().equals(product.getProductName())) {
				item.setQuantity(item.getQuantity() + 1);
				return;
			}
		}
		OrderedItem item = new OrderedItem(product, 1);
		this.itemList.add(item);
	}

}