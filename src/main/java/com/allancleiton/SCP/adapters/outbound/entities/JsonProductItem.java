package com.allancleiton.SCP.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonProductItem {

    @JsonProperty("codProduto")
    private final Integer productCode;

    @JsonProperty("qtde")
    private final Double weight;

    @JsonProperty("condicao")
    private final String condition;

    public JsonProductItem(Integer productCode, Double weight, String condition) {
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
}
