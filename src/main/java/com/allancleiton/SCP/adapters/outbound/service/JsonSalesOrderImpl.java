package com.allancleiton.SCP.adapters.outbound.service;

import com.allancleiton.SCP.adapters.outbound.entities.JsonSalesOrder;
import com.allancleiton.SCP.domain.entities.Order;
import com.allancleiton.SCP.domain.entities.ProductItem;
import com.allancleiton.SCP.domain.entities.SalesOrder;
import com.allancleiton.SCP.domain.repository.SalesOrderRepository;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonSalesOrderImpl implements SalesOrderRepository {

    @Override
    public SalesOrder getSalesOrder() {
        ObjectMapper mapper = new ObjectMapper();
        JsonSalesOrder wrapper;
        try(InputStream input = getClass().getResourceAsStream("/temp/CargaDeVenda.json")){
            wrapper = mapper.readValue(input, JsonSalesOrder.class);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(wrapper != null) {

            return new SalesOrder(wrapper.getSalesOrder(), wrapper.getOrders().stream().map(o -> new Order(
                    o.getOrderId(),
                    o.getClient(),
                    o.getState(),
                    o.getCity(),
                    o.getRoute(),
                    o.getSequence(),
                    o.getDataOrder(),
                    o.getProductItems().stream().map(jsonProductItem -> new ProductItem(
                            jsonProductItem.getProductCode(),
                            jsonProductItem.getWeight(),
                            jsonProductItem.getCondition()
                    )).toList()
            )).toList());
        }

        return null;
    }
}
