package com.company.PizzaStore;

import com.company.Interfaces.IPizza;
import com.company.Pizza.PizzaType;
import com.company.Pizza.ToppingType;
import com.company.PizzaStore.Informations.APizzaInformations;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class AbstractPizzaStore {

    private List<PizzaType> availablePizzas;
    private Map<PizzaType, String> ingredientOfPizzas;
    private Map<PizzaType, Integer> costOfPizzas;
    private List<ToppingType> availableToppings;
    private Map<ToppingType, Integer> costOfToppings;
    private APizzaInformations storeInformation;
    private String storeName;

    public AbstractPizzaStore(APizzaInformations storeInformation, String storeName) {
        this.storeInformation = storeInformation;
        this.storeName = storeName;
        initializer();
    }

    public IPizza orderPizza(int pizzaTypeIndex) {
        if (pizzaTypeIndex > availablePizzas.size() || pizzaTypeIndex < 0) {
            System.out.println("PizzaTypeIndex must be valid");
            System.exit(0);
        }
        PizzaType desiredPizza = availablePizzas.get(pizzaTypeIndex);
        return createPizza(desiredPizza, ingredientOfPizzas.get(desiredPizza), costOfPizzas.get(desiredPizza));
    }

    public List<String> getAvailablePizzas() {
        List<String> availablePizzas = new LinkedList<>();
        for (PizzaType availablePizza : this.availablePizzas) {
            availablePizzas.add(String.format("%-20s Pizza (%s) Cost: %d", availablePizza.name(), ingredientOfPizzas.get(availablePizza), costOfPizzas.get(availablePizza)));
        }

        return availablePizzas;
    }

    public List<String> getAvailableToppings() {

        List<String> availableToppingList = new LinkedList<>();

        for (ToppingType availableTopping : availableToppings
        ) {

            availableToppingList.add(String.format("%-21s - Cost : %d tl", availableTopping.getReadableNames(), costOfToppings.get(availableTopping)));

        }
        return availableToppingList;
    }

    public IPizza addTopping(IPizza pizza, int toppingIndex) {
        if (toppingIndex > availableToppings.size() || toppingIndex < 0) {
            System.out.println("PizzaTypeIndex must be valid");
            System.exit(0);
        }
        ToppingType desiredTopping = availableToppings.get(toppingIndex);
        return decorate(pizza, desiredTopping, costOfToppings.get(desiredTopping));


    }

    protected abstract IPizza decorate(IPizza pizza, ToppingType toppingType, int cost);


    protected abstract IPizza createPizza(PizzaType pizzaType, String ingredients, int cost);

    private void initializer() {
        try {

            availablePizzas = storeInformation.getAvailablePizzas();
            ingredientOfPizzas = storeInformation.getIngredientsOfPizzas();
            costOfPizzas = storeInformation.getCostOfPizzas();
            availableToppings = storeInformation.getAvailableToppings();
            costOfToppings = storeInformation.getCostOfToppings();

        } catch (Exception e) {
            System.out.println("Error occured at initializer function at AbstractPizzaStore.java error: " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return getStoreName();
    }

    public String getStoreName() {
        return storeName;
    }

    @Override
    public boolean equals(Object obj) {
        return ((AbstractPizzaStore)obj).getStoreName().equals(getStoreName());
    }
}