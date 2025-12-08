package com.allancleiton.SCP.domain.entities;


import java.time.LocalDate;

public class Product {
    private Long id;
    private Long codeNote;
    private Long code;
    private Double netWeightBox;
    private Short packets;
    private Pallet pallet;
    private LocalDate validity;
    private LocalDate production;
    private Integer cays;

    public Product(Long id, Long codeNote, Long code, Double netWeightBox, Short packets, Pallet pallet, LocalDate validity, LocalDate production, Integer cays) {
        this.id = id;
        this.codeNote = codeNote;
        this.code = code;
        this.netWeightBox = netWeightBox;
        this.packets = packets;
        this.pallet = pallet;
        this.validity = validity;
        this.production = production;
        this.cays = cays;
    }

    public Product(){}

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
        return cays;
    }
}