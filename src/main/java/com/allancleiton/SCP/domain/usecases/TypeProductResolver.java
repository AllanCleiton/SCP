package com.allancleiton.SCP.domain.usecases;

import com.allancleiton.SCP.domain.entities.Order;

import java.io.IOException;

public interface TypeProductResolver {
    Integer resolve(Integer codeProduct, Order order) throws IOException;
}
