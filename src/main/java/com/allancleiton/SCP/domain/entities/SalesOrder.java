package com.allancleiton.SCP.domain.entities;


import java.util.List;

public class SalesOrder {

    private final int salesOrder;

    private final List<Order> orders;

    public SalesOrder(int salesOrder, List<Order> orders) {
        this.salesOrder = salesOrder;
        this.orders = orders;
    }

    public int getSalesOrder() {
        return salesOrder;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "SalesOrder{\n" +
                "   salesOrder=" + salesOrder +
                ",\n    orders=" + orders +
                '}';
    }
}
