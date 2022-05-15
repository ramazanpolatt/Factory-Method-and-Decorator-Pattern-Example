package com.company;

import com.company.Interfaces.IOrder;
import com.company.Pizza.IPizza;
import com.company.PizzaStore.AbstractPizzaStore;
import com.company.PizzaStore.PizzaStoreFactory;
import com.company.PizzaStore.PizzaStoreName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PizzaStoreApp {

    private List<IOrder> orderList;
    private List<AbstractPizzaStore> pizzaStoreList;
    private AbstractPizzaStore selectedPizzaStore;
    private IPizza selectedPizza;


    public PizzaStoreApp() {

        initialize();

    }
    public void showAvailablePizzaStores()
    {
        int count=0;
        for (AbstractPizzaStore pizzaStore:pizzaStoreList
             ) {
            count+=1;
            System.out.println(count+"-) "+pizzaStore);
        }
    }

    public boolean selectPizzaStore(int pizzaStoreIndex)
    {
        boolean result=false;
        if(pizzaStoreIndex>pizzaStoreList.size()||pizzaStoreIndex<0)
        {
            System.out.println("Please enter a valid pizza store value");
            return result;
        }
        selectedPizzaStore=pizzaStoreList.get(pizzaStoreIndex-1);
        result=true;
        return result;

    }

    public void showAvailablePizzas()
    {

        Iterator<String> availablePizzaIterator= selectedPizzaStore.getAvailablePizzas().iterator();
        while(availablePizzaIterator.hasNext())
        {
            System.out.println(availablePizzaIterator.next());

        }
    }

    private void initialize()
    {
        orderList=new ArrayList<>();
        pizzaStoreList=new ArrayList<>();
        for (PizzaStoreName pizzaStoreName:PizzaStoreName.values()
             ) {
            pizzaStoreList.add(PizzaStoreFactory.getPizzaStore(pizzaStoreName));
        }

    }
}
