package com.allancleiton.SCP.adapters.outbound.service;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import com.allancleiton.SCP.adapters.outbound.entities.JpaProductEntity;
import com.allancleiton.SCP.adapters.outbound.repository.JpaPalletRepository;
import com.allancleiton.SCP.adapters.outbound.repository.JpaProductRepository;
import com.allancleiton.SCP.domain.entities.Pallet;
import com.allancleiton.SCP.domain.entities.Product;
import com.allancleiton.SCP.domain.repository.PalletRepository;
import com.allancleiton.SCP.domain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class JpaProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public JpaProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product findById(Long id) {
        Optional<JpaProductEntity> product = jpaProductRepository.findById(id);
        return product.map(p -> new Product(
                p.getId(),
                p.getCodeNote(),
                p.getCode(),
                p.getNetWeightBox(),
                p.getPackets(),
                new Pallet(
                        p.getPallet().getId(),
                        p.getPallet().getCodeNote(),
                        p.getPallet().getCode(),
                        p.getPallet().getChamber(),
                        p.getPallet().getRoad(),
                        p.getPallet().getPosition(),
                        p.getPallet().getDays(),
                        p.getPallet().getBoxes()
                ),
                p.getValidity(),
                p.getProduction(),
                p.getDays()
        )).orElse(null);
    }

    @Override
    public void save(Product product) {
        JpaProductEntity p = new JpaProductEntity(
                product.getId(),
                product.getCodeNote(),
                product.getCode(),
                product.getNetWeightBox(),
                product.getPackets(),
                new JpaPalletEntity(
                        product.getPallet().getId(),
                        product.getPallet().getCodeNote(),
                        product.getPallet().getCode(),
                        product.getPallet().getChamber(),
                        product.getPallet().getRoad(),
                        product.getPallet().getPosition(),
                        product.getPallet().getDays(),
                        product.getPallet().getBoxes()
                ),
                product.getValidity(),
                product.getProduction(),
                product.getDays()
        );
        jpaProductRepository.save(p);

    }

    public void save(JpaProductEntity product) {
        jpaProductRepository.save(product);

    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream().map(p -> new Product(
                p.getId(),
                p.getCodeNote(),
                p.getCode(),
                p.getNetWeightBox(),
                p.getPackets(),
                new Pallet(
                        p.getPallet().getId(),
                        p.getPallet().getCodeNote(),
                        p.getPallet().getCode(),
                        p.getPallet().getChamber(),
                        p.getPallet().getRoad(),
                        p.getPallet().getPosition(),
                        p.getPallet().getDays(),
                        p.getPallet().getBoxes()
                ),
                p.getValidity(),
                p.getProduction(),
                p.getDays()
        )).toList();
    }

    @Override
    public List<Product> findAllByCode(Long code) {
        return jpaProductRepository.findAllByCode(code).stream().map(p ->new Product(
                p.getId(),
                p.getCodeNote(),
                p.getCode(),
                p.getNetWeightBox(),
                p.getPackets(),
                new Pallet(
                        p.getPallet().getId(),
                        p.getPallet().getCodeNote(),
                        p.getPallet().getCode(),
                        p.getPallet().getChamber(),
                        p.getPallet().getRoad(),
                        p.getPallet().getPosition(),
                        p.getPallet().getDays(),
                        p.getPallet().getBoxes()
                ),
                p.getValidity(),
                p.getProduction(),
                p.getDays()
        )).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        this.jpaProductRepository.deleteById(id);
        return this.jpaProductRepository.findById(id).isEmpty();
    }
}
