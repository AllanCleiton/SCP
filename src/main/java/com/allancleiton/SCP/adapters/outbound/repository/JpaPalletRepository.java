package com.allancleiton.SCP.adapters.outbound.repository;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaPalletRepository  extends JpaRepository<JpaPalletEntity, Integer>  {

    @Query("SELECT p from JpaPalletEntity p WHERE p.codeNote = :code")
    List<JpaPalletEntity> findAllByCode(@Param("code") Integer code);
}
