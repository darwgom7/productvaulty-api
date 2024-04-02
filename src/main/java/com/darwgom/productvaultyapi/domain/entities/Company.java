package com.darwgom.productvaultyapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @Column(nullable = false, unique = true)
    private String nit;
    private String name;
    private String address;
    private String phone;
    @OneToMany(mappedBy = "company")
    private Set<Product> products;

}

