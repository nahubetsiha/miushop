package com.ea.miushop.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Purchase_Orders")
public class Purchase_Order {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long orderId;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long purchaser_id;
	
    private BigDecimal itemPrice;
    
    private String reciept;
    
    
    @ManyToOne
    @JoinColumn(name = "purchaser_Id")
    private Purchaser purchaser;

    
    @OneToOne(mappedBy="purchaseOrder", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
	private Order order;
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getPurchaser_id() {
		return purchaser_id;
	}

	public void setPurchaser_id(Long purchaser_id) {
		this.purchaser_id = purchaser_id;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getReciept() {
		return reciept;
	}

	public void setReciept(String reciept) {
		this.reciept = reciept;
	}

	public Purchaser getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
    
  

}
