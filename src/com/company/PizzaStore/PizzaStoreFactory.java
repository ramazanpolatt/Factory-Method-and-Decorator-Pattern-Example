package com.company.PizzaStore;

import Interfaces.IPizzaStore;

public class PizzaStoreFactory {
    public IPizzaStore getPizzaStore(PizzaStoreName storeName){
        IPizzaStore pizzaFactory = null;
        switch (storeName) {
            case MAMA_JONES:
                pizzaFactory = new MamaJonasPizzaStore();
                break;
            case PIZZA_GLOBALE:
                pizzaFactory = new PizzaGlobalePizzaStore();
                break;
            case PIZZA_HAT:
                pizzaFactory = new PizzaHatPizzaStore();
                break;

        }
        return pizzaFactory;
    }
    
}
