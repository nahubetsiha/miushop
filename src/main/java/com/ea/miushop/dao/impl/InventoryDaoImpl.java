package com.ea.miushop.dao.impl;

import com.ea.miushop.dao.InventoryDao;
import com.ea.miushop.domain.Inventory;
import com.ea.miushop.domain.StorageMovement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class InventoryDaoImpl extends GenericDaoImpl<Inventory> implements InventoryDao {
    @Override
    public List<StorageMovement> findStorageMovementCriteria(String productName, LocalDate date) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // Typed query - expected results are of the type StorageMovement
        CriteriaQuery<StorageMovement> query = criteriaBuilder.createQuery(StorageMovement.class);
        // From part of the clause
        Root<StorageMovement> storageMovementRoot = query.from(StorageMovement.class);
        // The Select
        query.select(storageMovementRoot);
        // Where
        query.where(criteriaBuilder.equal(storageMovementRoot.get("movementDate"),  date) );

        return (List<StorageMovement>) entityManager.createQuery( query ).getResultList();
    }
}
