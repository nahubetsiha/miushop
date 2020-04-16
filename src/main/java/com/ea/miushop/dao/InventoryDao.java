package com.ea.miushop.dao;

import com.ea.miushop.domain.Inventory;
import com.ea.miushop.domain.StorageMovement;

import java.time.LocalDate;
import java.util.List;

public interface InventoryDao extends GenericDao<Inventory> {
    public List<StorageMovement> findStorageMovementCriteria(String productName, LocalDate date);
}
