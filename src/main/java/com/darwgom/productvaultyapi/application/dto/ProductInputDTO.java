package com.darwgom.productvaultyapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInputDTO {

    private String code;
    private String name;
    private String features;
    private BigDecimal price;
    private String companyNit;

}
