package com.darwgom.productvaultyapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryInputDTO {
    private Long productId;
    private String companyNit;
    private Integer quantity;
}