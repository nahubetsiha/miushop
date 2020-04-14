package com.ea.miushop.repository;

import com.ea.miushop.domain.StorageMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ea.miushop.domain.Inventory;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    List<StorageMovement> getAllMovements(Long id);
}
