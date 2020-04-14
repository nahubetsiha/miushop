package com.ea.miushop_cart.model;

import java.math.BigDecimal;

import com.ea.miushop.domain.*;

public class OrderedItem {
	private Product product;
	private int quantity;
	
	public OrderedItem()
	{
	}
	
	public OrderedItem(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		this.product = product;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public BigDecimal getSubTotal()
	{
		return product.getPrice().multiply(new BigDecimal(quantity));
	}
}
