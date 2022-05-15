package com.company;

import com.company.ConcreteClasses.Order;
import com.company.Interfaces.IOrder;
import com.company.Pizza.IPizza;
import com.company.PizzaStore.AbstractPizzaStore;
import com.company.PizzaStore.PizzaStoreFactory;
import com.company.PizzaStore.PizzaStoreName;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PizzaStoreApp {

    private List<IOrder> orderList;
    private List<AbstractPizzaStore> pizzaStoreList;
    private AbstractPizzaStore selectedPizzaStore;
    private IPizza selectedPizza;
    private Scanner scanner;


    public PizzaStoreApp() {

        initialize();


    }
    public void run()
    {
        int pizzaStoreIndex;
        boolean hasStoreSelected=false;
        while(!hasStoreSelected)
        {

            showAvailablePizzaStores();
            System.out.println("Please select a pizzaStore");
            pizzaStoreIndex= scanner.nextInt();
            if(selectPizzaStore(pizzaStoreIndex))
                hasStoreSelected=true;

        }

        int pizzaIndex;
        boolean hasPizzaSelected=false;
        while(!hasPizzaSelected)
        {

            showAvailablePizzas();
            System.out.println("Please select a pizza");
            pizzaIndex= scanner.nextInt();
            if(selectPizza((pizzaIndex)))
            {

                hasPizzaSelected=true;
            }


        }

        boolean hasToppingSectionFinished=false;
        while(!hasToppingSectionFinished)
        {
            showAvailableToppings();
            System.out.printf("Please select a toppping\n" +
                    "To finish topping section please enter 0 \n");
            int toppingIndex=scanner.nextInt();
            if(toppingIndex==0)
            {
                orderList.add(new Order(selectedPizza));
                showOrders();
                hasToppingSectionFinished=true;
            }
            else
            {
                selectTopping(toppingIndex);
            }

        }


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
        if(pizzaStoreIndex>pizzaStoreList.size()||pizzaStoreIndex<=0)
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
        int count=0;
        while(availablePizzaIterator.hasNext())
        {
            count++;
            System.out.println(count+"-) "+ availablePizzaIterator.next());

        }
    }

    public boolean selectPizza(int selectedPizzaIndex)
    {
        boolean result=false;
        if(selectedPizzaIndex>selectedPizzaStore.getAvailablePizzas().size()||selectedPizzaIndex<=0)
        {
            System.out.println("Please enter a valid pizza index value");
            return result;
        }
        selectedPizza= selectedPizzaStore.orderPizza(selectedPizzaIndex-1);
        showSelectedPizza();

        result=true;
        return result;
    }




    public void showAvailableToppings()
    {
        Iterator<String> availableToppingIterator= selectedPizzaStore.getAvailableToppings().iterator();
        int count=0;
        while(availableToppingIterator.hasNext())
        {
            count++;
            System.out.println(count+"-) "+ availableToppingIterator.next());

        }
    }

    public boolean selectTopping(int selectedToppingIndex)
    {
        boolean result=false;
        if(selectedToppingIndex>selectedPizzaStore.getAvailableToppings().size()||selectedToppingIndex<=0)
        {
            System.out.println("Please enter a valid pizza index value");
            return result;
        }
        selectedPizza= selectedPizzaStore.addTopping(selectedPizza,selectedToppingIndex-1);
        showSelectedPizza();

        result=true;
        return result;
    }
    private void initialize()
    {
        scanner=new Scanner(System.in);
        orderList=new ArrayList<>();
        pizzaStoreList=new ArrayList<>();
        for (PizzaStoreName pizzaStoreName:PizzaStoreName.values()
             ) {
            pizzaStoreList.add(PizzaStoreFactory.getPizzaStore(pizzaStoreName));
        }

    }

    public void showOrders()
    {
        System.out.println("Pizza Shop : "+selectedPizzaStore.getStoreName());
        System.out.println("Pizzas : ");

        int count=0,totalCost=0;
        for (IOrder order:orderList
             ) {
            count++;
            totalCost+=order.getCost();
            System.out.printf("%d. %s",count,order.getOrderedPizza());

        }
        System.out.println("Total Number of Pizzas : " +count);
        System.out.println("Total cost : "+totalCost+" tl");
    }
    private void showSelectedPizza()
    {
        System.out.println("Selected Pizza : "+selectedPizza);
    }
}
