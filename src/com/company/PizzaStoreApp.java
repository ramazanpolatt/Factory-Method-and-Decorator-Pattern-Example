package com.company;

import com.company.Order.Order;
import com.company.Interfaces.IOrder;
import com.company.Interfaces.IPizza;
import com.company.PizzaStore.AbstractPizzaStore;
import com.company.PizzaStore.PizzaStoreFactory;
import com.company.PizzaStore.PizzaStoreName;

import java.util.*;
import java.util.logging.ConsoleHandler;

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

        while(true)
        {

                selectPizzaStoreSection();
                while(true)
                {
                    showNavigation();
                    try{


                        int navigationIndex=scanner.nextInt();
                        switch (navigationIndex)
                        {
                            case 1:
                                orderOperations();
                                break;
                            case 2:
                                selectPizzaSection();
                                addToppingSection();
                                break;
                            case 3:
                                selectPizzaStoreSection();
                                break;
                            default:
                                break;
                        }
                    }
                    catch (InputMismatchException exception)
                    {
                        System.err.println("Please enter a valid navigation value");
                        scanner.next();
                    }
                }
        }
    }


    private void orderOperations() {
        if(orderList.isEmpty())
        {

            System.out.println("There is no order");

        }
        boolean exitPressed=false;
        while(!orderList.isEmpty()&&!exitPressed){
            showOrders();
            System.out.println("Please enter the order that number that you want to cancel or enter 0 to go back main menu");
            try {
                int orderSelection = scanner.nextInt();
                if (orderSelection != 0) {
                    if (orderSelection > orderList.size() || orderSelection <= 0) {
                        System.out.println("Please enter a valid order");
                    } else {
                        cancelOrder(orderSelection);
                    }
                } else {
                    exitPressed = true;
                }
            }
            catch (InputMismatchException exception)
            {
                System.err.println("Please enter a valid  value");
                scanner.next();
            }
        }
    }


    private void selectPizzaStoreSection() {
        AbstractPizzaStore currentPizzaStore=null;
        if(selectedPizzaStore!=null)
        {
            currentPizzaStore=selectedPizzaStore;
            selectedPizzaStore=null;

        }
        while (selectedPizzaStore == null) {

            showAvailablePizzaStores();
            selectPizzaStore();
            if(currentPizzaStore!=null && !currentPizzaStore.equals(selectedPizzaStore))
            {
                orderList.clear();
            }

        }
    }

    private void selectPizzaSection() {
        while (selectedPizza == null) {

            showAvailablePizzas();
            selectPizza();

        }
    }

    private void addToppingSection() {
        boolean hasToppingSectionFinished = false;
        while (!hasToppingSectionFinished)
        {
            showAvailableToppings();

            System.out.print("""
                    Please select a toppping To finish topping section please enter (0) \n\s
                    """);
            try
            {


            int toppingIndex = scanner.nextInt();
            if (toppingIndex == 0) {
                orderList.add(new Order(selectedPizza));
                hasToppingSectionFinished = true;
                selectedPizza = null;
            } else
            {
                addTopping(toppingIndex);
            }
            }
            catch (InputMismatchException exception)
            {
                System.err.println("Please enter a valid topping value");
                scanner.next();
            }
        }
    }

    private void selectPizza() {
        int pizzaIndex;
        System.out.println("Please select a pizza");
        try{
            pizzaIndex= scanner.nextInt();
            selectPizza((pizzaIndex));
        }
        catch (InputMismatchException exception)
        {
            System.err.println("Please enter a valid pizza value");
            scanner.next();
        }


    }

    private void selectPizzaStore() {
        int pizzaStoreIndex;
        System.out.println("Please select a pizzaStore");
        try{
            pizzaStoreIndex= scanner.nextInt();
            selectPizzaStore(pizzaStoreIndex);
        }
        catch (InputMismatchException exception)
        {
            System.err.println("Please enter a valid pizza store value");
            scanner.next();
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
        printDashedLine();

    }

    private void cancelOrder(int orderIndex)
    {
        orderList.remove(orderIndex-1);
    }


    public void selectPizzaStore(int pizzaStoreIndex)
    {

        if(pizzaStoreIndex>pizzaStoreList.size()||pizzaStoreIndex<=0)
        {
            System.out.println("Please enter a valid pizza store value");

        }

        selectedPizzaStore=pizzaStoreList.get(pizzaStoreIndex-1);    }

    public void showNavigation()
    {
        System.out.println("1.See or cancel your orders");
        if(orderList.isEmpty())
        {
            System.out.println("2.Order pizza");
        }
        else
        {
            System.out.println("2.Order another pizza");
        }

        System.out.println("3.Go back to pizza shop selection");
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

    public void selectPizza(int selectedPizzaIndex)
    {

        if(selectedPizzaIndex>selectedPizzaStore.getAvailablePizzas().size()||selectedPizzaIndex<=0)
        {
            System.out.println("Please enter a valid pizza index value");

        }
        selectedPizza= selectedPizzaStore.orderPizza(selectedPizzaIndex-1);
        showSelectedPizza();

    }




    public void showAvailableToppings()
    {
        Iterator<String> availableToppingIterator= selectedPizzaStore.getAvailableToppings().iterator();
        int count=0;
        while(availableToppingIterator.hasNext())
        {
            count++;
            System.out.printf("%3d -) %s\n",count,availableToppingIterator.next());


        }
    }

    public void addTopping(int selectedToppingIndex)
    {

        if(selectedToppingIndex>selectedPizzaStore.getAvailableToppings().size()||selectedToppingIndex<=0)
        {
            System.err.println("Please enter a valid pizza index value");

        }
        else
        {
            selectedPizza= selectedPizzaStore.addTopping(selectedPizza,selectedToppingIndex-1);
            showSelectedPizza();
        }





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
        System.out.println("Orders:");
        System.out.println("Pizza Shop : "+selectedPizzaStore.getStoreName());
        System.out.println("Pizzas : ");

        int count=0,totalCost=0;
        for (IOrder order:orderList
             ) {
            count++;
            totalCost+=order.getCost();
            System.out.printf("%d. %s \n",count,order.getOrderedPizza());

        }
        System.out.println("Total Number of Pizzas : " +count);
        System.out.println("Total cost : "+totalCost+" tl");
        printDashedLine();

    }
    private void showSelectedPizza()
    {
        System.out.println("Selected Pizza : "+selectedPizza);
    }

    private void printDashedLine()
    {

        System.out.println("-------------------------------------------------------------");
    }
}
