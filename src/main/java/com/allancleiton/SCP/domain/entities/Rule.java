package com.allancleiton.SCP.domain.entities;

import java.util.List;

public class Rule {

    private final Integer id;
    private final String ruleName;
    private final Integer days;
    private final List<Integer> listProducts;

    public Rule(Integer id, String ruleName, Integer days, List<Integer> listProducts) {
        this.id = id;
        this.ruleName = ruleName;
        this.days = days;
        this.listProducts = listProducts;
    }

    public String getRuleName() {
        return ruleName;
    }

    public Integer getDays() {
        return days;
    }

    public List<Integer> getListProducts() {
        return listProducts;
    }

    public Integer getId() {
        return id;
    }

}
