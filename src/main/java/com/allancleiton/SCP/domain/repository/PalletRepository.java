package com.allancleiton.SCP.domain.repository;

import com.allancleiton.SCP.domain.entities.Pallet;

import java.util.List;

public interface PalletRepository {
    Pallet findById(Integer id);
    void save(Pallet pallet);
    List<Pallet> findAll();
    List<Pallet> findAllByCode(Integer code);
    Boolean deleteById(Integer id);

}
