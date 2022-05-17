package com.company.Decorator;

import com.company.Interfaces.IPizza;
import com.company.Pizza.PizzaType;

public abstract class AbstractPizzaDecorator  implements IPizza {

    private IPizza pizza;

    public AbstractPizzaDecorator(IPizza pizza) {
        this.pizza=pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }

    @Override
    public String getIngredients() {
        return pizza.getIngredients();
    }

    @Override
    public PizzaType getPizzaType() {
        return pizza.getPizzaType();
    }

    @Override
    public String toString() {
        return String.format("%s Pizza Ingredients:  (%s) Cost: %d  ",getPizzaType(),getIngredients(),getCost());
    }
}
