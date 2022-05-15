package com.company;

import com.company.Interfaces.IOrder;
import com.company.Pizza.IPizza;
import com.company.PizzaStore.AbstractPizzaStore;

import java.util.List;

public class PizzaStoreApp {

    private List<IOrder> orderList;
    private List<AbstractPizzaStore> pizzaStoreList;
    private AbstractPizzaStore selectedPizzaStore;
    private IPizza selectedPizza;

    public PizzaStoreApp() {
        this.orderList = orderList;
        this.pizzaStoreList = pizzaStoreList;
    }
}
