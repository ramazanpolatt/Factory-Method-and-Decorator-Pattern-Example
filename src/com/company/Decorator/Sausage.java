package com.company.Decorator;

import com.company.Pizza.IPizza;
import com.company.Pizza.ToppingType;

public class Sausage extends AbstractPizzaDecorator{
    private int cost;


    public Sausage(IPizza pizza,int cost) {
        super(pizza);
        this.cost=cost;
    }


    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" ,"+ ToppingType.SAUSAGE.getReadableNames();

    }

}
