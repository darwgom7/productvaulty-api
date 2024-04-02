package com.darwgom.productvaultyapi.application.usecases.implement;

import com.darwgom.productvaultyapi.application.dto.MessageDTO;
import com.darwgom.productvaultyapi.application.dto.ProductDTO;
import com.darwgom.productvaultyapi.application.dto.ProductInputDTO;
import com.darwgom.productvaultyapi.application.usecases.IProductUseCase;
import com.darwgom.productvaultyapi.domain.entities.Company;
import com.darwgom.productvaultyapi.domain.entities.Product;
import com.darwgom.productvaultyapi.domain.exceptions.EntityNotFoundException;
import com.darwgom.productvaultyapi.domain.repositories.CompanyRepository;
import com.darwgom.productvaultyapi.domain.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductUseCase implements IProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductInputDTO productInputDTO) {
        Company company = companyRepository.findByNit(productInputDTO.getCompanyNit())
                .orElseThrow(() -> new EntityNotFoundException("Company not found with NIT: " + productInputDTO.getCompanyNit()));

        Product product = modelMapper.map(productInputDTO, Product.class);
        product.setCompany(company);

        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductInputDTO productInputDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        modelMapper.map(productInputDTO, product);

        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public MessageDTO deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
        return new MessageDTO("Product deleted successfully!");
    }


}

