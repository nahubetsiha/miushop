package com.ea.miushop.service.impl;

import com.ea.miushop.domain.*;
import com.ea.miushop.repository.ItemRepository;
import com.ea.miushop.repository.OrderRepository;
import com.ea.miushop.repository.PurchaseOrderRepository;
import com.ea.miushop.service.InventoryService;
import com.ea.miushop.service.ItemService;
import com.ea.miushop.service.MailService;
import com.ea.miushop.service.OrderService;
import com.ea.miushop.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	MailService mailService;
	@Autowired
	ItemService itemService;

	@Autowired
	InventoryService inventoryService;

	@Autowired
	PurchaseOrderService purchaseOrderService;

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrder(Long id) {
		return orderRepository.getOne(id);
	}

	@Override
	public void makeOrder(Order order) {

		for (Item i : order.getItems()) {
			i.setOrder(order);
			itemService.saveItem(i);
			orderRepository.save(order);
			System.out.println("hi");
		}
		Mail mail = new Mail();
		mail.setMailFrom("shop@miu.edu");
		mail.setMailTo("merryhaddis@gmail.com");
		mail.setMailSubject("Order Confirmation");
		mail.setMailContent("Order has been sent successfully, ");
		mailService.sendEmail(mail);
	}

	@Override
	public void processOrder(Long orderId) {

		Order order = orderRepository.getOne(orderId);

		boolean allItemsBought = true;

		List<Item> itemList = itemService.findAllByOrder(order);

		for (Item i : itemList) {

			if (!i.isBought()) {
				int orderQuantity = i.getQuantity();
				int quantityInInventory = inventoryService.getInventoryQuantity(i.getProduct());

				if (quantityInInventory >= orderQuantity) {
					Inventory inventory = inventoryService.getInventoryByProduct(i.getProduct());
					inventory.setQuantity(quantityInInventory - orderQuantity);
					inventoryService.updateInventory(inventory);
					i.setBought(true);

				} else {
					allItemsBought = false;
					PurchaseOrder purchaseOrder = new PurchaseOrder();
					purchaseOrder.setOrder(order);
					int neededQuantity = orderQuantity - quantityInInventory;
					purchaseOrder.setProduct(i.getProduct());
					purchaseOrder.setCategory(i.getProduct().getCategory());
					purchaseOrder.setQuantity(neededQuantity);

					purchaseOrderService.savePurchaseOrder(purchaseOrder);
					order.addPurchaseOrder(purchaseOrder);

					orderRepository.save(order);
				}
			}
		}

		order.setOrderStatus(Order.Status.PROCESSED);
		orderRepository.save(order);

		if (allItemsBought) {
			order.setOrderStatus(Order.Status.BOUGHT);
			orderRepository.save(order);
		}
	}

	@Override
	public void buyOrder(Long purchaseOrderId) {

		PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrder(purchaseOrderId);

		if (purchaseOrder != null && !purchaseOrder.isBought()) {
			int oldQuantity = inventoryService.getInventoryQuantity(purchaseOrder.getProduct());
			int boughtQuantity = purchaseOrder.getQuantity();

			Inventory inventory = inventoryService.getInventoryByProduct(purchaseOrder.getProduct());
			inventory.setQuantity(oldQuantity + boughtQuantity);

			inventoryService.updateInventory(inventory);

			purchaseOrder.setBought(true);

			Order order = orderRepository.findByPurchaseOrders(purchaseOrder);
			processOrder(order.getOrderId());
		}
	}

	@Override
	public void deliverOrder(Order order) {

	}
}
