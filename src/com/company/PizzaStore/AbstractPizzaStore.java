package com.company.PizzaStore;

import com.company.Pizza.PizzaType;
import com.company.Pizza.ToppingType;

import java.util.List;
import java.util.Map;

public abstract class AbstractPizzaStore {

    private List<PizzaType> availablePizzaTypes;
    private Map<PizzaType,String> ingredientOfPizzas;
    private Map<PizzaType,Integer> costOfPizzas;

    private List<ToppingType> availableToppings;
    private Map<ToppingType,Integer> costOfToppings;

    public void orderPizza(int pizzaTypeIndex)
    {

    }
    protected abstract  void orderPizza(PizzaType pizzaType);

}
