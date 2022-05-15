package com.company.Decorator;

import com.company.Pizza.IPizza;
import com.company.Pizza.PizzaType;

import java.util.List;

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

}
