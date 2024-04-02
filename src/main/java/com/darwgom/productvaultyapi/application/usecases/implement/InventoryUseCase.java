package com.darwgom.productvaultyapi.application.usecases.implement;

import com.darwgom.productvaultyapi.application.dto.InventoryDTO;
import com.darwgom.productvaultyapi.application.dto.InventoryDetailDTO;
import com.darwgom.productvaultyapi.application.dto.InventoryInputDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.usecases.IInventoryUseCase;
import com.darwgom.productvaultyapi.domain.entities.Company;
import com.darwgom.productvaultyapi.domain.entities.Inventory;
import com.darwgom.productvaultyapi.domain.entities.Product;
import com.darwgom.productvaultyapi.domain.exceptions.EntityNotFoundException;
import com.darwgom.productvaultyapi.domain.repositories.CompanyRepository;
import com.darwgom.productvaultyapi.domain.repositories.InventoryRepository;
import com.darwgom.productvaultyapi.domain.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryUseCase implements IInventoryUseCase {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<InventoryDTO> getAllInventory() {
        List<Inventory> inventoryList = inventoryRepository.findAll();
        return inventoryList.stream()
                .map(inventory -> modelMapper.map(inventory, InventoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryDetailDTO> getAllInventoryDetail() {
        return inventoryRepository.findAllInventoryDetails();
    }

    @Override
    public InventoryDTO createInventory(InventoryInputDTO inventoryInputDTO) {
        Product product = productRepository.findById(inventoryInputDTO.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + inventoryInputDTO.getProductId()));
        Company company = companyRepository.findByNit(inventoryInputDTO.getCompanyNit())
                .orElseThrow(() -> new EntityNotFoundException("Company not found with NIT: " + inventoryInputDTO.getCompanyNit()));

        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setCompany(company);
        inventory.setQuantity(inventoryInputDTO.getQuantity());

        Inventory savedInventory = inventoryRepository.save(inventory);
        return modelMapper.map(savedInventory, InventoryDTO.class);
    }

    @Override
    public InventoryDTO updateInventory(Long inventoryId, InventoryInputDTO inventoryInputDTO) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new EntityNotFoundException("Inventory not found with id: " + inventoryId));

        if (inventoryInputDTO.getProductId() != null) {
            Product product = productRepository.findById(inventoryInputDTO.getProductId())
                    .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + inventoryInputDTO.getProductId()));
            inventory.setProduct(product);
        }

        if (inventoryInputDTO.getCompanyNit() != null) {
            Company company = companyRepository.findByNit(inventoryInputDTO.getCompanyNit())
                    .orElseThrow(() -> new EntityNotFoundException("Company not found with NIT: " + inventoryInputDTO.getCompanyNit()));
            inventory.setCompany(company);
        }

        inventory.setQuantity(inventoryInputDTO.getQuantity());
        Inventory updatedInventory = inventoryRepository.save(inventory);
        return modelMapper.map(updatedInventory, InventoryDTO.class);
    }

    @Override
    public MessageDTO deleteInventory(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new EntityNotFoundException("Inventory not found with id: " + inventoryId));

        inventoryRepository.delete(inventory);
        return new MessageDTO("Inventory deleted successfully!");
    }

}

