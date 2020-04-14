package com.ea.miushop.service;

import com.ea.miushop.domain.StorageMovement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StorageMovementService {
    List<StorageMovement> getAllMovements();
    StorageMovement getStorageMovement();
    void enterMovement(StorageMovement movement);
}
