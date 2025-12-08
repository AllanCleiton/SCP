package com.allancleiton.SCP.adapters.outbound.service;

import com.allancleiton.SCP.adapters.outbound.entities.JpaPalletEntity;
import com.allancleiton.SCP.adapters.outbound.repository.JpaPalletRepository;
import com.allancleiton.SCP.domain.entities.Pallet;
import com.allancleiton.SCP.domain.repository.PalletRepository;


import java.util.List;
import java.util.Optional;

public class JpaPalletRepositoryImpl implements PalletRepository {

    private final JpaPalletRepository jpaPalletRepository;

    public JpaPalletRepositoryImpl(JpaPalletRepository jpaPalletRepository) {
        this.jpaPalletRepository = jpaPalletRepository;
    }

    @Override
    public Pallet findById(Long id) {
        Optional<JpaPalletEntity> pallet = jpaPalletRepository.findById(id);
        return pallet.map(p -> new Pallet(
                p.getId(),
                p.getCodeNote(),
                p.getCode(),
                p.getChamber(),
                p.getRoad(),
                p.getPosition(),
                p.getDays(),
                p.getBoxes()
        )).orElse(null);
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
        return jpaPalletRepository.findAll().stream().map(p -> new Pallet(
                p.getId(),
                p.getCodeNote(),
                p.getCode(),
                p.getChamber(),
                p.getRoad(),
                p.getPosition(),
                p.getDays(),
                p.getBoxes()
        )).toList();
    }

    @Override
    public List<Pallet> findAllByCode(Long code) {
        return jpaPalletRepository.findAllByCode(code).stream().map(p -> new Pallet(
                p.getId(),
                p.getCodeNote(),
                p.getCode(),
                p.getChamber(),
                p.getRoad(),
                p.getPosition(),
                p.getDays(),
                p.getBoxes()
        )).toList();
    }

    @Override
    public Boolean deleteById(Long id) {
        this.jpaPalletRepository.deleteById(id);
        return this.jpaPalletRepository.findById(id).isEmpty();
    }
}
