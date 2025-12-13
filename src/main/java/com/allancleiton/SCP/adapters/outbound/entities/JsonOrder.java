package com.allancleiton.SCP.adapters.outbound.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonOrder {
    @JsonProperty("pedido")
    private final Integer OrderId;

    @JsonProperty("cliente")
    private final Integer client;

    @JsonProperty("estado")
    private final String state;

    @JsonProperty("cidade")
    private final String city;

    @JsonProperty("rota")
    private final Integer route;

    @JsonProperty("sequencia")
    private final Integer Sequence;

    @JsonProperty("dataPedido")
    private final String dataOrder;

    @JsonProperty("produtos")
    private final List<JsonProductItem> productItems;


    public JsonOrder(Integer orderId, Integer client, String state, String city, Integer route, Integer sequence, String dataOrder, List<JsonProductItem> productItems) {
        OrderId = orderId;
        this.client = client;
        this.state = state;
        this.city = city;
        this.route = route;
        Sequence = sequence;
        this.dataOrder = dataOrder;
        this.productItems = productItems;

    }

    public int getOrderId() {
        return OrderId;
    }

    public int getClient() {
        return client;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public int getRoute() {
        return route;
    }

    public int getSequence() {
        return Sequence;
    }

    public String getDataOrder() {
        return dataOrder;
    }

    public List<JsonProductItem> getProductItems() {
        return productItems;
    }
}
