package com.allancleiton.SCP.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonSalesOrder {

    @JsonProperty("cargaVenda")
    private final Integer salesOrder;

    @JsonProperty("pedidos")
    private final List<JsonOrder> orders;

    public JsonSalesOrder(Integer salesOrder, List<JsonOrder> orders) {
        this.salesOrder = salesOrder;
        this.orders = orders;
    }

    public int getSalesOrder() {
        return salesOrder;
    }

    public List<JsonOrder> getOrders() {
        return orders;
    }
}
