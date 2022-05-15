package com.company.PizzaStore.Informations;

import com.company.Pizza.PizzaType;
import com.company.Pizza.ToppingType;
import com.company.IPizzaStorePizzaInformation;
import com.company.IPizzaStoreToppingsInformation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class APizzaInformations {
    protected List<IPizzaStorePizzaInformation>  pizzaInfo;
    protected List<IPizzaStoreToppingsInformation> toppingsInfo;


    protected APizzaInformations(List<IPizzaStorePizzaInformation> pizzaInfo, List<IPizzaStoreToppingsInformation> toppingsInfo) {
        this.pizzaInfo = pizzaInfo;
        this.toppingsInfo = toppingsInfo;
    }

    public List<PizzaType> getAvailablePizzas() {
        List<PizzaType> tempNameList = new ArrayList<>();
        for (IPizzaStorePizzaInformation element :
                pizzaInfo) {
            for (PizzaType pizzaType :
                    PizzaType.values()) {
                    if (element.toString().equals(pizzaType.toString())) {
                        tempNameList.add(pizzaType);
                        break;
                    }//end of if
                }// end of inner foreach
        }
        return tempNameList;
    }

    public Map<PizzaType,String> getIngredientsOfPizzas(){
        Map<PizzaType,String> tempList = new LinkedHashMap<>();
        List<PizzaType> tempPizzas = getAvailablePizzas();
        for (int i = 0; i < pizzaInfo.size(); i++) {
            tempList.put(tempPizzas.get(i),pizzaInfo.get(i).getIngeridients());
        }
        return tempList;
    }

    public Map<PizzaType,Integer> getCostOfPizzas(){
        Map<PizzaType,Integer> tempMap = new LinkedHashMap<>();
        List<PizzaType> tempPizzas = getAvailablePizzas();
        for (int i = 0; i < pizzaInfo.size(); i++) {
            tempMap.put(tempPizzas.get(i),pizzaInfo.get(i).getCost());
        }
        return tempMap;
    }


    public List<ToppingType> getAvailableToppings() {
        List<ToppingType> tempList = new ArrayList<>();
        for (IPizzaStoreToppingsInformation element :
                toppingsInfo) {
            for (ToppingType toppingType :
                    ToppingType.values()) {
                if (element.toString().equals(toppingType.toString())) {
                    tempList.add(toppingType);
                    break;
                }//end of if
            }// end of inner foreach
        }
        return tempList;
    }

    public Map<ToppingType,Integer> getCostOfToppings(){
        Map<ToppingType,Integer> tempMap = new LinkedHashMap<>();
        List<ToppingType> tempToppings = getAvailableToppings();
        for (int i = 0; i < toppingsInfo.size() ; i++) {
            tempMap.put(tempToppings.get(i),toppingsInfo.get(i).getCost());
        }
        return tempMap;
    }


    /*public IPizzaStorePizzaInformation getPizza(String pizzaName){
        IPizzaStorePizzaInformation tempPizza = null;
        for (int i = 0; i < pizzaInfo.size(); i++) {
            if (pizzaInfo.get(i).toString().equals(pizzaName)){
                tempPizza = pizzaInfo.get(i);
                break;
            }
        }
        return  tempPizza;
    }*/





}
