package com.ea.miushop.service.impl;

import com.ea.miushop.domain.StorageMovement;
import com.ea.miushop.repository.StorageMovementRepository;
import com.ea.miushop.service.StorageMovementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StorageMovementServiceImpl implements StorageMovementService {

    @Autowired
    StorageMovementRepository storageMovementRepository;

    @Override
    public List<StorageMovement> getAllStorageMovements() {
        return storageMovementRepository.findAll();
    }

    @Override
    public StorageMovement getStorageMovement(Long id) {
        return storageMovementRepository.getOne(id);
    }

    @Override
    public void makeStorageMovement(StorageMovement storageMovement) {
        storageMovementRepository.save(storageMovement);
    }
}
