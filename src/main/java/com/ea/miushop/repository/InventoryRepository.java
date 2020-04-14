package com.ea.miushop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ea.miushop.domain.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
