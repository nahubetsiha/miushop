package com.ea.miushop.domain;

import javax.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "order")
    private List<Item> items;

    private LocalDate orderDate;

    private boolean orderBought;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    
    @OneToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL) 
	@JoinColumn(name="OrderId") 
	private Purchase_Order purchaseOrder;


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public boolean isOrderBought() {
		return orderBought;
	}


	public void setOrderBought(boolean orderBought) {
		this.orderBought = orderBought;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Purchase_Order getPurchaseOrder() {
		return purchaseOrder;
	}


	public void setPurchaseOrder(Purchase_Order purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
    
    
    
}
