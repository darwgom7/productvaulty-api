package com.darwgom.productvaultyapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDetailDTO {
    private Long inventoryId;
    private Integer quantity;

    // Company details
    private String companyNit;
    private String companyName;
    private String companyAddress;
    private String companyPhone;

    // Product details
    private String productCode;
    private String productName;
    private String productFeatures;
    private BigDecimal productPrice;
}
