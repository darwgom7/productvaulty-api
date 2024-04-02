package com.darwgom.productvaultyapi.application.dto;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private CustomerDTO customer;
    private Set<ProductDTO> products;

}
