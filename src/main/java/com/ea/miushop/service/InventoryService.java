package com.ea.miushop.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.StorageMovement;
import org.springframework.stereotype.Service;

import com.ea.miushop.domain.Inventory;

public interface InventoryService {
	List<Inventory> getAllInventory();
    Inventory getInventory(Long id);
//    List<StorageMovement> getAllMovements(Long id);
    void enterInventory(Inventory inventory);
    void updateInventory(Long inventoryId, StorageMovement storageMovement);
    Integer getInventoryQuantity(Product product);
    Inventory getInventoryByProduct(Product product);
    List<Inventory> findAllSubSelect();
    List<StorageMovement> findStorageMovements(Long inventoryId);
}
