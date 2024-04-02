package com.darwgom.productvaultyapi.infrastructure.controllers;

import com.darwgom.productvaultyapi.application.dto.InventoryDTO;
import com.darwgom.productvaultyapi.application.dto.InventoryDetailDTO;
import com.darwgom.productvaultyapi.application.dto.InventoryInputDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.usecases.IInventoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/inventories")
@RestController
public class InventoryController {

    @Autowired
    private IInventoryUseCase inventoryUseCase;

    @GetMapping
    public ResponseEntity<List<InventoryDTO>> getAllInventory() {
        List<InventoryDTO> inventoryList = inventoryUseCase.getAllInventory();
        return new ResponseEntity<>(inventoryList, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<List<InventoryDetailDTO>> getAllInventoryDetail() {
        List<InventoryDetailDTO> inventoryDetailList = inventoryUseCase.getAllInventoryDetail();
        return new ResponseEntity<>(inventoryDetailList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryInputDTO inventoryInputDTO) {
        InventoryDTO inventoryDTO = inventoryUseCase.createInventory(inventoryInputDTO);
        return new ResponseEntity<>(inventoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable Long id, @RequestBody InventoryInputDTO inventoryInputDTO) {
        InventoryDTO updatedInventory = inventoryUseCase.updateInventory(id, inventoryInputDTO);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteInventory(@PathVariable Long id) {
        MessageDTO message = inventoryUseCase.deleteInventory(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}

