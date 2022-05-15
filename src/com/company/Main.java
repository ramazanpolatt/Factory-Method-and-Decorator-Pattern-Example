package com.company;

import com.company.Decorator.AbstractPizzaDecorator;
import com.company.Decorator.BasilLeaves;
import com.company.Decorator.Salami;
import com.company.Pizza.IPizza;
import com.company.Pizza.Pizza;
import com.company.Pizza.PizzaType;

public class Main {

    public static void main(String[] args) {
	// write your code here

        IPizza pizza = new Pizza(10,"ali", PizzaType.SMOKED_RIBS);
        AbstractPizzaDecorator newPizza = new BasilLeaves(pizza,5);
        System.out.printf("Pizza ingredients %s cost %d\n",newPizza.getIngredients(),newPizza.getCost());

        AbstractPizzaDecorator decoratedPizza = new Salami(newPizza, 10);
        System.out.printf("Pizza ingredients %s cost %d",decoratedPizza.getIngredients(),decoratedPizza.getCost());

    }
}
