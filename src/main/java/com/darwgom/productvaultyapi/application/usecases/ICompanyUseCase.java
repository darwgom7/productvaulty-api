package com.darwgom.productvaultyapi.application.usecases;

import com.darwgom.productvaultyapi.application.dto.CompanyDTO;
import com.darwgom.productvaultyapi.application.dto.CompanyInputDTO;
import com.darwgom.productvaultyapi.application.dto.MessageDTO;

import java.util.List;

public interface ICompanyUseCase {

    List<CompanyDTO> getAllCompanies();
    CompanyDTO createCompany(CompanyInputDTO companyInputDTO);
    CompanyDTO updateCompany(String nit, CompanyInputDTO companyInputDTO);
    MessageDTO deleteCompany(String nit);

}
