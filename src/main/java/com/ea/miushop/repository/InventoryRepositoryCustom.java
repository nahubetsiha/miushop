package com.ea.miushop.repository;

import com.ea.miushop.domain.StorageMovement;

import java.time.LocalDateTime;
import java.util.List;

public interface InventoryRepositoryCustom<Inventory> {

    public List<StorageMovement> findStorageMovementCriteria(Long inventoryId) ;
}
