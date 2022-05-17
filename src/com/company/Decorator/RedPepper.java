package com.company.Decorator;

import com.company.Interfaces.IPizza;
import com.company.Pizza.ToppingType;

public class RedPepper extends AbstractPizzaDecorator{


    private int cost;

    public RedPepper(IPizza pizza, int cost) {
        super(pizza);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" ,"+  ToppingType.RED_PEPPER.getReadableNames();

    }
}