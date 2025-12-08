package com.allancleiton.SCP.adapters.outbound.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_pallet")
public class JpaPalletEntity {

    @Id
    private Long id;
    private Long codeNote;
    private Long code;
    private String chamber;
    private String road;
    private String position;
    private Integer days;
    private Integer boxes;
    @OneToMany(mappedBy = "pallet", fetch = FetchType.LAZY)
    List<JpaProductEntity> products;

    public JpaPalletEntity(Long id, Long codeNote, Long code, String chamber, String road, String position, Integer days, Integer boxes) {
        this.code = code;
        this.codeNote = codeNote;
        this.chamber = chamber;
        this.road = road;
        this.position = position;
        this.id = id;
        this.days = days;
        this.boxes = boxes;
    }

    public JpaPalletEntity(){}

    public JpaPalletEntity(Long id){
        this.id = id;
    }

    public void setProducts(List<JpaProductEntity> list){
        this.products = list;
    }

    public Long getId() {
        return id;
    }

    public Long getCodeNote() {
        return codeNote;
    }

    public Long getCode() {
        return code;
    }

    public String getChamber() {
        return chamber;
    }

    public String getRoad() {
        return road;
    }

    public String getPosition() {
        return position;
    }

    public Integer getDays() {
        return days;
    }

    public Integer getBoxes() {
        return boxes;
    }

    public List<JpaProductEntity> getProducts() {
        return products;
    }
}
