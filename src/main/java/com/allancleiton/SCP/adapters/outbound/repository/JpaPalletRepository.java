package com.allancleiton.SCP.adapters.outbound.repository;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaPalletRepository extends JpaRepository<JpaPalletEntity, Long> {}
