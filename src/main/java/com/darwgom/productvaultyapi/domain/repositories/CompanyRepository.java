package com.darwgom.productvaultyapi.domain.repositories;

import com.darwgom.productvaultyapi.domain.entities.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends CrudRepository<Company, String> {
    Optional<Company> findByNit(String nit);

    List<Company> findAll();
}
