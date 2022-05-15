package com.company.PizzaStore;



public  class PizzaStoreFactory {
    public static AbstractPizzaStore getPizzaStore(PizzaStoreName storeName){
        AbstractPizzaStore pizzaFactory = null;
        switch (storeName) {
            case MAMA_JONES:
                pizzaFactory = new MamaJonesPizzaStore();
                break;
            case PIZZA_GLOBALE:
                pizzaFactory = new PizzaGlobaleStore();
                break;
            case PIZZA_HAT:
                pizzaFactory = new PizzaHatStore();
                break;

        }
        return pizzaFactory;
    }
    
}
