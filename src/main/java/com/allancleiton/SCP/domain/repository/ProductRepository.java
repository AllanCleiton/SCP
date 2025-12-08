package com.allancleiton.SCP.domain.repository;

import com.allancleiton.SCP.domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    Product save(Product product);
    List<Product> findAll();
    void delete(Long id);
    List<Product> findAllByCode(Long code);

}
