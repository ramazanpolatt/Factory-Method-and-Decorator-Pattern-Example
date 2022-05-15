package com.company.PizzaStore;

import com.company.Decorator.*;
import com.company.Pizza.IPizza;
import com.company.Pizza.Pizza;
import com.company.Pizza.PizzaType;

import com.company.Pizza.ToppingType;
import com.company.PizzaStore.Informations.MamaJonesPizzaStoreInformation;
import com.company.PizzaStore.Informations.PizzaGlobalePizzaStoreInformation;


public  class PizzaGlobaleStore extends AbstractPizzaStore{

    public PizzaGlobaleStore()
    {
        super(new PizzaGlobalePizzaStoreInformation());


    }


    @Override
    protected IPizza decorate(IPizza pizza, ToppingType toppingType,int cost)
    {
        IPizza tempPizza=null;
        switch (toppingType)
        {

            case PARMESAN_CHEESE:
                tempPizza=new ParmesanCheese(pizza,cost);
                break;
            case OLIVE:
                tempPizza=new Olive(pizza,cost);
                break;
            case RICOTTA_CHEESE:
                tempPizza=new RicottaCheese(pizza,cost);
                break;
            case SWEET_CORN:
                tempPizza= new SweetCorn(pizza,cost);
                break;
            case RED_PEPPER:
                tempPizza= new RedPepper(pizza,cost);
                break;
            case SAUSAGE:
                tempPizza=new Sausage(pizza,cost);
                break;
            case PEPPERONI:
                tempPizza=new Pepperoni(pizza,cost);
                break;
            case PASTRAMI:
                tempPizza=new Pastrami(pizza,cost);
                break;
            case BASIL_LEAVES:
                tempPizza=new BasilLeaves(pizza,cost);
                break;
            case CHERRY_TOMATO:
                tempPizza=new CherryTomato(pizza,cost);
                break;
            case MUSHROOM:
                tempPizza=new Mushroom(pizza,cost);
                break;
            default:
                System.out.println("Unexpected topping type");
                System.exit(0);

        }
        return tempPizza;
    }

    @Override
    protected IPizza createPizza(PizzaType pizzaType, String ingredients, int cost) {

        return new Pizza(pizzaType,ingredients,cost);
    }
}
