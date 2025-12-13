package com.allancleiton.SCP.domain.entities;

public class ProductItem {

    private final int productCode;

    private final double weight;

    private final String condition;

    public ProductItem(int productCode, double weight, String condition) {
        this.productCode = productCode;
        this.weight = weight;
        this.condition = condition;
    }

    public int getProductCode() {
        return productCode;
    }

    public double getWeight() {
        return weight;
    }

    public String getCondition() {
        return condition;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "\n            productCode=" + productCode +
                ",\n            weight=" + weight +
                ",\n            condition='" + condition + '\'' +
                "}\n";
    }
}
