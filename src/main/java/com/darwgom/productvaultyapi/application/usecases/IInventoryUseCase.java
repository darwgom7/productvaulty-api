package com.darwgom.productvaultyapi.application.usecases;

import com.darwgom.productvaultyapi.application.dto.InventoryDTO;
import com.darwgom.productvaultyapi.application.dto.InventoryDetailDTO;
import com.darwgom.productvaultyapi.application.dto.InventoryInputDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;

import java.util.List;

public interface IInventoryUseCase {
    List<InventoryDTO> getAllInventory();
    List<InventoryDetailDTO> getAllInventoryDetail();
    InventoryDTO createInventory(InventoryInputDTO inventoryInputDTO);
    InventoryDTO updateInventory(Long id, InventoryInputDTO inventoryInputDTO);
    MessageDTO deleteInventory(Long id);
}
