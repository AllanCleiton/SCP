package com.allancleiton.SCP.adapters.outbound.repository;

import com.allancleiton.SCP.adapters.outbound.entities.JpaProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaProductRepository extends JpaRepository<JpaProductEntity, Long> {
}
