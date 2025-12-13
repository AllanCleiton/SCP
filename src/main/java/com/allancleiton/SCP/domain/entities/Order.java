package com.allancleiton.SCP.domain.entities;

import java.util.List;

public class Order {

    private final int OrderId;

    private final int client;

    private final String state;

    private final String city;

    private final int route;

    private final int Sequence;

    private final String dataOrder;

    private final List<ProductItem> productItems;


    public Order(int orderId, int client, String state, String city, int route, int sequence, String dataOrder, List<ProductItem> productItems) {
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

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    @Override
    public String toString() {
        return "Order{\n" +
                "        OrderId=" + OrderId +
                ",\n        client=" + client +
                ",\n        state='" + state + '\'' +
                ",\n        city='" + city + '\'' +
                ",\n        route=" + route +
                ",\n        Sequence=" + Sequence +
                ",\n        dataOrder='" + dataOrder + '\'' +
                ",\n        productItems=" + productItems +
                '}';
    }
}
