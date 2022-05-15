package com.company.Decorator;

import com.company.Pizza.IPizza;

public class Mushroom extends AbstractPizzaDecorator{


    private int cost;

    public Mushroom(IPizza pizza, int cost) {
        super(pizza);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" "+  ToppingType.MUSHROOM.getReadableNames();

    }
}