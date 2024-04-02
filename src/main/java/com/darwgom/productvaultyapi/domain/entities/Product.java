package com.darwgom.productvaultyapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;
    private String name;
    private String features;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "company_nit", nullable = false)
    private Company company;

    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

}

