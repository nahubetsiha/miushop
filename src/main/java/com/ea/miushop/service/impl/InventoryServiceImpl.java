package com.ea.miushop.service.impl;

import java.util.List;

import com.ea.miushop.domain.Inventory;
import com.ea.miushop.domain.StorageMovement;
import com.ea.miushop.repository.InventoryRepository;
import com.ea.miushop.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	@Override
	public Inventory getInventory(Long id) {
		return inventoryRepository.getOne(id);
	}

//	@Override
//	public List<StorageMovement> getAllMovements(Long id) {
//		return inventoryRepository.getAllMovements(id);
//	}

	@Override
	public void enterInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
	}

	@Override
	public void updateInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
	}

}
