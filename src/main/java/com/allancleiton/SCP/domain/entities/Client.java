package com.allancleiton.SCP.domain.entities;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private final Integer id;
    private List<Integer> rules = new ArrayList<>();

    public Client(Integer id) {
        this.id = id;

    }

    public Integer getId() {
        return id;
    }

    public void setRules(List<Integer> rules){
        this.rules = rules;
    }

    private List<Integer> getRulesId(){
        return this.rules;
    }

    public List<Rule> getRules(ObjectMapper mapper) {
        List<Rule> listRule = new ArrayList<>();
        for(Integer r : getRulesId()){
            listRule.add(mapper.readValue(new File("temp/config/RegrasPorClientes/45423.json" + getId() + ".json"), Rule.class));
        }
        return listRule;
    }

}
