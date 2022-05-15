package com.company.Pizza;

import java.util.List;

public class Pizza implements IPizza {


    private int cost;
    private String ingredients;
    private PizzaType pizzaType;

    public Pizza( PizzaType pizzaType,String ingredients,int cost) {
        this.cost = cost;
        this.ingredients = ingredients;
        this.pizzaType = pizzaType;
    }


    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String getIngredients() {
        return ingredients;
    }

    @Override
    public PizzaType getPizzaType() {
        return pizzaType;
    }

    @Override
    public String toString() {
        return String.format("%s Pizza ingredients : %s Cost: %d",pizzaType.name(),ingredients,cost);
    }
}
