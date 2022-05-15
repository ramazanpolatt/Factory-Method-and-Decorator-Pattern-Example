package com.company.Decorator;

import com.company.Pizza.IPizza;
import com.company.Pizza.ToppingType;

import java.util.List;
import java.util.stream.Stream;

public class BasilLeaves extends AbstractPizzaDecorator{
    private int cost;


    public BasilLeaves(IPizza pizza,int cost) {
        super(pizza);
        this.cost=cost;

    }

    @Override
    public int getCost() {
        return super.getCost()+cost;
    }

    @Override
    public String getIngredients() {

        return super.getIngredients()+" "+  ToppingType.BASIL_LEAVES.getReadableNames();

    }
}
