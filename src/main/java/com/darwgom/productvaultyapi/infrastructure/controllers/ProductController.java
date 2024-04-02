package com.darwgom.productvaultyapi.infrastructure.controllers;

import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.dto.ProductDTO;
import com.darwgom.productvaultyapi.application.dto.ProductInputDTO;
import com.darwgom.productvaultyapi.application.usecases.IProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/products")
@RestController
public class ProductController {

    @Autowired
    private IProductUseCase productUseCase;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productUseCase.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductInputDTO productInputDTO) {
        ProductDTO productDTO = productUseCase.createProduct(productInputDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductInputDTO productInputDTO) {
        ProductDTO updatedProduct = productUseCase.updateProduct(id, productInputDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteProduct(@PathVariable Long id) {
        MessageDTO message = productUseCase.deleteProduct(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


}

