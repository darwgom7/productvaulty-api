package com.darwgom.productvaultyapi.infrastructure.controllers;

import com.darwgom.productvaultyapi.application.dto.CompanyDTO;
import com.darwgom.productvaultyapi.application.dto.CompanyInputDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.usecases.ICompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RequestMapping("/api/companies")
@RestController
public class CompanyController {
    @Autowired
    private ICompanyUseCase companyUseCase;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companies = companyUseCase.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@Valid @RequestBody CompanyInputDTO companyInputDTO) {
        CompanyDTO createdCompany = companyUseCase.createCompany(companyInputDTO);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable String nit, @Valid @RequestBody CompanyInputDTO companyInputDTO) {
        CompanyDTO updatedCompany = companyUseCase.updateCompany(nit, companyInputDTO);
        return ResponseEntity.ok(updatedCompany);
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<MessageDTO> deleteCompany(@PathVariable String nit) {
        MessageDTO message = companyUseCase.deleteCompany(nit);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}

