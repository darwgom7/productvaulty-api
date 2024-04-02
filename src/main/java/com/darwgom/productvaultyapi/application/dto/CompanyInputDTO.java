package com.darwgom.productvaultyapi.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInputDTO {

    @NotBlank(message = "NIT is required and can't be empty")
    private String nit;
    @NotBlank(message = "Name is required and can't be empty")
    private String name;
    private String address;
    private String phone;

}
