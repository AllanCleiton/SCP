package com.allancleiton.SCP.application.service;

import com.allancleiton.SCP.domain.usecases.Entity;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConditionInterpreter <T extends Entity>{
    private boolean existCondition;
    private Condition condicao;


    public  ConditionInterpreter(String rule)  {
        if (rule != null){
            this.existCondition = true;
        }else{
            this.existCondition = false;
            rule = "";
        }

        String regex =
                "^\\s*(>=|<=|==|!=|>|<)\\s*(\\d+)(?:\\s*(\\&\\&|\\|\\|)\\s*(>=|<=|==|!=|>|<)\\s*(\\d+))?\\s*$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(rule);

        if (m.matches()) {
            existCondition = true;

            this.condicao = new Condition();
            condicao.comp1 = m.group(1);
            condicao.value1 = Integer.parseInt(m.group(2));

            condicao.logic = m.group(3); // <<<<<< OPERADOR LÓGICO AQUI
            condicao.comp2 = m.group(4);
            String value2Str = m.group(5);

            condicao.value2 = value2Str != null ? Integer.parseInt(value2Str) : null;

            System.out.println("Primeira comparação: " + condicao.comp1);
            System.out.println("Primeiro valor: " + condicao.value1);

            if (condicao.logic != null) {
                System.out.println("Operador lógico: " + condicao.logic);
                System.out.println("Segunda comparação: " + condicao.comp2);
                System.out.println("Segundo valor: " + condicao.value2);
            } else {
                System.out.println("Não existe segunda condição.");
            }

        } else {
            System.out.println("Campo inválido!");
        }


    }

    public List<T>  submit(List<T> lit){
        
        Predicate<T> pred = createsPredicate(this.condicao);

        List<T> preList = lit.stream()
                .filter(pred)
                .toList();

        return lit.stream()
                .filter(pred)
                .toList();
    }

    private Predicate<T> createsPredicate(Condition c) {
        if (!(existCondition))
            return null;

        Predicate<T> p1 = obj -> compare(obj.getDays(), c.comp1, c.value1);

        if (c.logic == null) {
            return p1; // só uma condição
        }

        Predicate<T> p2 =  obj -> compare(obj.getDays(), c.comp2, c.value2);

        if (c.logic.equals("&&")) {
            return p1.and(p2);
        } else { // ||
            return p1.or(p2);
        }
    }


    private boolean compare(int valor, String operador, int compared) {
        return switch (operador) {
            case ">"  -> valor >  compared;
            case ">=" -> valor >= compared;
            case "<"  -> valor <  compared;
            case "<=" -> valor <= compared;
            case "==" -> valor == compared;
            case "!=" -> valor != compared;
            default   -> throw new RuntimeException("Operador inválido: " + operador);
        };
    }

    private static class Condition {
        String comp1;
        int value1;
        String logic; // && ou ||
        String comp2;          // opcional
        Integer value2;

        public Condition(String comp1, int value1, String logic, String comp2, Integer value2) {
            this.comp1 = comp1;
            this.value1 = value1;
            this.logic = logic;
            this.comp2 = comp2;
            this.value2 = value2;
        }

        public Condition(){}
    }


}


