package com.company.PizzaStore;

import com.company.Pizza.IPizza;
import com.company.Pizza.Pizza;
import com.company.Pizza.PizzaType;

import com.company.Pizza.ToppingType;
import com.company.PizzaStore.Informations.MamaJonesPizzaStoreInformation;


public  class MamaJonesPizzaStore extends AbstractPizzaStore{


    public MamaJonesPizzaStore()
    {
        super(new MamaJonesPizzaStoreInformation());


    }


    @Override
    protected IPizza decorate(IPizza pizza, ToppingType toppingType) {
        return null;
    }

    @Override
    protected IPizza createPizza(PizzaType pizzaType, String ingredients, int cost) {

        return new Pizza(pizzaType,ingredients,cost);
    }
}
