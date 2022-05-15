package com.company;

import com.company.Decorator.AbstractPizzaDecorator;
import com.company.Decorator.BasilLeaves;
import com.company.Decorator.Salami;
import com.company.Pizza.IPizza;
import com.company.Pizza.Pizza;
import com.company.Pizza.PizzaType;
import com.company.PizzaStore.AbstractPizzaStore;
import com.company.PizzaStore.MamaJonesPizzaStore;

public class Main {

    public static void main(String[] args) {
	// write your code here



        AbstractPizzaStore pizzaStore = new MamaJonesPizzaStore();
        int count=0;
        for (String info:pizzaStore.getAvailablePizzas()
             ) {
            count+=1;
            System.out.println(count+"-)  "+info);
        }
        System.out.println(pizzaStore.orderPizza(0));

    }
}
