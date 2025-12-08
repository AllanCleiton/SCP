package com.allancleiton.SCP.domain.entities;

import java.util.List;


public class Pallet {

    private Long id;
    private Long codeNote;
    private Long code;
    private String chamber;
    private String road;
    private String position;
    private Integer days;
    private Integer boxes;

    private List<Product> products;

    public Pallet(Long id, Long codeNote, Long code, String chamber, String road, String position, Integer days, Integer boxes) {
        this.code = code;
        this.codeNote = codeNote;
        this.chamber = chamber;
        this.road = road;
        this.position = position;
        this.id = id;
        this.days = days;
        this.boxes = boxes;
    }

    public Pallet(Long codeNote){
        this.codeNote = codeNote;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
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

    public List<Product> getProducts() {
        return products;
    }

    public Long getCodeNote() {
        return codeNote;
    }

    public Long getCode() {
        return code;
    }
}
