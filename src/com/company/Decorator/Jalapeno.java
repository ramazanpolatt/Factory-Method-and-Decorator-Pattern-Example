package com.company.Decorator;

import com.company.Pizza.IPizza;

public class Jalapeno extends AbstractPizzaDecorator{


    private int cost;

    public Jalapeno(IPizza pizza, int cost) {
        super(pizza);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" "+  ToppingType.JALAPENO.getReadableNames();

    }
}