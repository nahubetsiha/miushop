package com.ea.miushop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ea.miushop.domain.Inventory;

@Service
public interface InventoryService {
	List<Inventory> getAllInventory();
    Inventory getInventory(Long id);
    void enterInventory(Inventory inventory);
    void updateInventory(Inventory inventory);
}
