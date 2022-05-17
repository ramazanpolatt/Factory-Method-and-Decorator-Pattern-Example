package com.company.Order;

import com.company.Interfaces.IOrder;
import com.company.Interfaces.IPizza;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements IOrder {

    private IPizza orderedPizza;
    private Date date;

    public Order(IPizza orderedPizza) {
        this.orderedPizza = orderedPizza;
        date= new Date();
    }

    @Override
    public IPizza getOrderedPizza() {
        return orderedPizza;
    }

    @Override
    public String getOrderTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);

    }

    @Override
    public int getCost() {
        return orderedPizza.getCost();
    }
}
