package com.darwgom.productvaultyapi.domain.repositories;

import com.darwgom.productvaultyapi.application.dto.InventoryDetailDTO;
import com.darwgom.productvaultyapi.domain.entities.Inventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    @Query("SELECT new com.darwgom.productvaultyapi.application.dto.InventoryDetailDTO(" +
            "i.id, i.quantity, " +
            "c.nit, c.name, c.address, c.phone, " +
            "p.code, p.name, p.features, p.price) " +
            "FROM Inventory i " +
            "JOIN i.product p " +
            "JOIN i.company c")
    List<InventoryDetailDTO> findAllInventoryDetails();

    List<Inventory> findAll();
}
