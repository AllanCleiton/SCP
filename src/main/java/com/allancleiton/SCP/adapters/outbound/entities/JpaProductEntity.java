package com.allancleiton.SCP.adapters.outbound.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "tb_product")
public class JpaProductEntity {
    @Id
    private Long id;
    private Long codeNote;
    private Long code;
    private Double netWeightBox;
    private Short packets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pallet_fk", nullable = true)
    private JpaPalletEntity pallet;
    private LocalDate validity;
    private LocalDate production;
    private Integer days;

    public JpaProductEntity(Long id, Long codeNote, Long code, Double netWeightBox, Short packets, JpaPalletEntity pallet, LocalDate validity, LocalDate production, Integer days) {
        this.id = id;
        this.codeNote = codeNote;
        this.code = code;
        this.netWeightBox = netWeightBox;
        this.packets = packets;
        this.pallet = pallet;
        this.validity = validity;
        this.production = production;
        this.days = days;
    }

    public JpaProductEntity(Long id, Long codeNote, Long code, Double netWeightBox, Short packets, LocalDate validity, LocalDate production, Integer days) {
        this.id = id;
        this.codeNote = codeNote;
        this.code = code;
        this.netWeightBox = netWeightBox;
        this.packets = packets;
        this.validity = validity;
        this.production = production;
        this.days = days;
    }

    public JpaProductEntity(){}

    public Long getId() {
        return id;
    }

    public Long getCodeNote() {
        return codeNote;
    }

    public Long getCode() {
        return code;
    }

    public Double getNetWeightBox() {
        return netWeightBox;
    }

    public Short getPackets() {
        return packets;
    }

    public JpaPalletEntity getPallet() {
        return pallet;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public LocalDate getProduction() {
        return production;
    }

    public Integer getDays() {
        return days;
    }
}

