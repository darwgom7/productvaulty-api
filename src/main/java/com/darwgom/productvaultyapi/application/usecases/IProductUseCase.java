package com.darwgom.productvaultyapi.application.usecases;

import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.dto.ProductDTO;
import com.darwgom.productvaultyapi.application.dto.ProductInputDTO;

import java.util.List;

public interface IProductUseCase {

    List<ProductDTO> getAllProducts();
    ProductDTO createProduct(ProductInputDTO productInputDTO);
    ProductDTO updateProduct(Long id, ProductInputDTO productInputDTO);
    MessageDTO deleteProduct(Long id);

}
