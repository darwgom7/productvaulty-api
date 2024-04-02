package com.darwgom.productvaultyapi.application.dto;

import java.math.BigDecimal;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String code;
    private String name;
    private String features;
    private BigDecimal price;
    private CompanyDTO company;
    private Set<CategoryDTO> categories;

}

