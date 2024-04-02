package com.darwgom.productvaultyapi.application.dto;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    private String nit;
    private String name;
    private String address;
    private String phone;
    private Set<ProductDTO> products;

}

