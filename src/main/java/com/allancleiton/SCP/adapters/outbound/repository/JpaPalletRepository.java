package com.allancleiton.SCP.adapters.outbound.repository;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface JpaPalletRepository extends JpaRepository<JpaPalletEntity, Long> {

    @Query("select p from JpaPalletEntity p where p.code = :code")
    List<JpaPalletEntity> findAllByCode(@Param("code") Long code);
}
