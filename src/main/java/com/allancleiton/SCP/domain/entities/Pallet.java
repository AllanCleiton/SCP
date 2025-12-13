package com.allancleiton.SCP.domain.entities;

import com.allancleiton.SCP.domain.usecases.Entity;

import java.util.List;


public class Pallet implements Entity {

    private Integer id;
    private final Integer codeNote;
    private Integer code;
    private String chamber;
    private String road;
    private String position;
    private Integer days;
    private Integer boxes;

    private List<Product> products;

    public Pallet(Integer id, Integer codeNote, Integer code, String chamber, String road, String position, Integer days, Integer boxes) {
        this.code = code;
        this.codeNote = codeNote;
        this.chamber = chamber;
        this.road = road;
        this.position = position;
        this.id = id;
        this.days = days;
        this.boxes = boxes;
    }

    public Pallet(Integer codeNote){
        this.codeNote = codeNote;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getId() {
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

    public Integer getCodeNote() {
        return codeNote;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "id=" + id +
                ", codeNote=" + codeNote +
                ", code=" + code +
                ", chamber='" + chamber + '\'' +
                ", road='" + road + '\'' +
                ", position='" + position + '\'' +
                ", days=" + days +
                ", boxes=" + boxes +
                '}';
    }
}
