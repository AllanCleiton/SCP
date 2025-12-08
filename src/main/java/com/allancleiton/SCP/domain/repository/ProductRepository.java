package com.allancleiton.SCP.domain.repository;

import com.allancleiton.SCP.domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    void save(Product product);
    List<Product> findAll();
    Boolean deleteById(Long id);
    List<Product> findAllByCode(Long code);

}
