package com.allancleiton.SCP.adapters.outbound.service;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import com.allancleiton.SCP.adapters.outbound.repository.JpaPalletRepository;
import com.allancleiton.SCP.domain.entities.Pallet;
import com.allancleiton.SCP.domain.repository.PalletRepository;


import java.util.List;

public class JpaPalletRepositoryImpl implements PalletRepository {

    private final JpaPalletRepository jpaPalletRepository;

    public JpaPalletRepositoryImpl(JpaPalletRepository jpaPalletRepository) {
        this.jpaPalletRepository = jpaPalletRepository;
    }

    @Override
    public Pallet findById(Long id) {
        return null;
    }

    @Override
    public void save(Pallet pallet) {
        JpaPalletEntity p = new JpaPalletEntity(
                pallet.getId(),
                pallet.getCodeNote(),
                pallet.getCode(),
                pallet.getChamber(),
                pallet.getRoad(),
                pallet.getPosition(),
                pallet.getDays(),
                pallet.getBoxes()

        );
        jpaPalletRepository.save(p);

    }

    public void save(JpaPalletEntity pallet) {
        jpaPalletRepository.save(pallet);

    }

    @Override
    public List<Pallet> findAll() {
        return List.of();
    }

    @Override
    public List<Pallet> findAllByCode(Long code) {
        return List.of();
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
