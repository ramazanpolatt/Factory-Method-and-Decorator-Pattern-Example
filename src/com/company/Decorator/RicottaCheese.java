package com.company.Decorator;

import com.company.Interfaces.IPizza;
import com.company.Pizza.ToppingType;

public class RicottaCheese extends AbstractPizzaDecorator{


    private int cost;

    public RicottaCheese(IPizza pizza, int cost) {
        super(pizza);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" ,"+  ToppingType.RICOTTA_CHEESE.getReadableNames();

    }
}