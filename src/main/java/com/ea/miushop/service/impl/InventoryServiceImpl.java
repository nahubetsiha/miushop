package com.ea.miushop.service.impl;

import java.util.List;

import com.ea.miushop.domain.Inventory;
import com.ea.miushop.domain.Product;
import com.ea.miushop.repository.InventoryRepository;
import com.ea.miushop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory getInventory(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enterInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		inventoryRepository.save(inventory);
		
	}

	@Override
	public Integer getInventoryQuantity(Product product) {
		Inventory inventory = inventoryRepository.findByProduct(product);

		return inventory.getQuantity();
	}

	@Override
	public Inventory getInventoryByProduct(Product product) {
		return inventoryRepository.findByProduct(product);
	}

}
