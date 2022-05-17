package com.company.Decorator;

import com.company.Interfaces.IPizza;
import com.company.Pizza.ToppingType;

public class Olive extends AbstractPizzaDecorator{


    private int cost;

    public Olive(IPizza pizza, int cost) {
        super(pizza);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" ,"+  ToppingType.OLIVE.getReadableNames();

    }
}