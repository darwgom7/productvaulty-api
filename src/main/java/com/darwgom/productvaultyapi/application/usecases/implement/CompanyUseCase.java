package com.darwgom.productvaultyapi.application.usecases.implement;

import com.darwgom.productvaultyapi.application.dto.CompanyDTO;
import com.darwgom.productvaultyapi.application.dto.CompanyInputDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.usecases.ICompanyUseCase;
import com.darwgom.productvaultyapi.domain.entities.Company;
import com.darwgom.productvaultyapi.domain.exceptions.EntityNotFoundException;
import com.darwgom.productvaultyapi.domain.exceptions.ValueAlreadyExistsException;
import com.darwgom.productvaultyapi.domain.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyUseCase implements ICompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO createCompany(CompanyInputDTO companyInputDTO) {
        if (companyRepository.findByNit(companyInputDTO.getNit()).isPresent()) {
            throw new ValueAlreadyExistsException("The NIT provided already exists.");
        }
        Company company = modelMapper.map(companyInputDTO, Company.class);
        Company savedCompany = companyRepository.save(company);
        return modelMapper.map(savedCompany, CompanyDTO.class);
    }

    @Override
    public CompanyDTO updateCompany(String nit, CompanyInputDTO companyInputDTO) {
        Company company = companyRepository.findByNit(nit)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with NIT: " + nit));

        company.setName(companyInputDTO.getName());
        company.setAddress(companyInputDTO.getAddress());
        company.setPhone(companyInputDTO.getPhone());

        Company updatedCompany = companyRepository.save(company);
        return modelMapper.map(updatedCompany, CompanyDTO.class);
    }

    @Override
    public MessageDTO deleteCompany(String nit) {
        Company company = companyRepository.findByNit(nit)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with NIT: " + nit));

        companyRepository.delete(company);
        return new MessageDTO("Company deleted successfully!");
    }

}
