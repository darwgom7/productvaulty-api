package com.darwgom.productvaultyapi.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {

    private Long id;
    private ProductDTO product;
    private CompanyDTO company;
    private Integer quantity;

}

