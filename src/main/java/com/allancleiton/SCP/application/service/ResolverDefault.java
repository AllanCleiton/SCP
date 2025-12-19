package com.allancleiton.SCP.application.service;

import com.allancleiton.SCP.domain.entities.Client;
import com.allancleiton.SCP.domain.entities.Order;
import com.allancleiton.SCP.domain.entities.Rule;
import com.allancleiton.SCP.domain.usecases.TypeProductResolver;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ResolverDefault implements TypeProductResolver {

    private final ObjectMapper mapper;

    public ResolverDefault(ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public Integer resolve(Integer codeProduct, Order order) throws IOException {
        var idClient = order.getClient();


        Client client = mapper.readValue(new File(idClient + ".json"), Client.class);

        if(client != null){
            for(Rule r: client.getRules(mapper)){
                if(r.getListProducts().contains(codeProduct)){
                    return r.getDays();
                }
            }
        }

        var UFMA = order.getState();
        client = mapper.readValue(new File(UFMA + ".json"), Client.class);

        if(client != null){
            for(Rule r: client.getRules(mapper)){
                if(r.getListProducts().contains(codeProduct)){
                    return r.getDays();
                }
            }
        }

        return null;


    }
}
