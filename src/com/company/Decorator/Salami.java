package com.company.Decorator;

import com.company.Pizza.IPizza;

public class Salami extends AbstractPizzaDecorator{
    private int cost;


    public Salami(IPizza pizza,int cost) {
        super(pizza);
        this.cost=cost;
    }


    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" "+ToppingType.SALAMI.getReadableNames();

    }

}
