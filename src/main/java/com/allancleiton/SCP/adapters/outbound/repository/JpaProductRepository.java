package com.allancleiton.SCP.adapters.outbound.repository;

import com.allancleiton.SCP.adapters.outbound.entities.JpaProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface JpaProductRepository extends JpaRepository<JpaProductEntity, Long> {

    @Query("select p from JpaProductEntity p where p.code = :code")
    List<JpaProductEntity> findAllByCode(@Param("code") Long code);
}
