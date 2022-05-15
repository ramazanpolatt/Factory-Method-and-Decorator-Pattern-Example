package com.company.Interfaces;

import com.company.Pizza.IPizza;

public interface IOrder {

    public IPizza getOrderedPizza();

    public String getOrderTime();

    public int getCost();
}
