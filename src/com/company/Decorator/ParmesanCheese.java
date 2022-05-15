package com.company.Decorator;

import com.company.Pizza.IPizza;

public class ParmesanCheese extends AbstractPizzaDecorator{


    private int cost;

    public ParmesanCheese(IPizza pizza, int cost) {
        super(pizza);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" "+  ToppingType.PARMESAN_CHEESE.getReadableNames();

    }
}