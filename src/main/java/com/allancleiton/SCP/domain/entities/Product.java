package com.allancleiton.SCP.domain.entities;


import com.allancleiton.SCP.domain.usecases.Entity;

import java.time.LocalDate;

public class Product implements Entity {
    private Long id;
    private Integer codeNote;
    private Integer code;
    private Double netWeightBox;
    private Short packets;
    private Pallet pallet;
    private LocalDate validity;
    private LocalDate production;
    private Integer days;

    public Product(Long id, Integer codeNote, Integer code, Double netWeightBox, Short packets, Pallet pallet, LocalDate validity, LocalDate production, Integer days) {
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

    public Product(){}

    public Long getId() {
        return id;
    }

    public Integer getCodeNote() {
        return codeNote;
    }

    public Integer getCode() {
        return code;
    }

    public Double getNetWeightBox() {
        return netWeightBox;
    }

    public Short getPackets() {
        return packets;
    }

    public Pallet getPallet() {
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