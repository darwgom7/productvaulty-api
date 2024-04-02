package com.darwgom.productvaultyapi.domain.repositories;

import com.darwgom.productvaultyapi.domain.entities.Company;
import com.darwgom.productvaultyapi.domain.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
