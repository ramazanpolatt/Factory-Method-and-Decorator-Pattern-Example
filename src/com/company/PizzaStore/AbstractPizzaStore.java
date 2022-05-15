package com.company.PizzaStore;

import com.company.Pizza.PizzaType;
import com.company.Pizza.ToppingType;
import com.company.PizzaStore.Informations.APizzaInformations;

import java.util.List;
import java.util.Map;

public abstract class AbstractPizzaStore {

    private List<PizzaType> availablePizzaTypes;
    private Map<PizzaType,String> ingredientOfPizzas;
    private Map<PizzaType,Integer> costOfPizzas;

    private List<ToppingType> availableToppings;
    private Map<ToppingType,Integer> costOfToppings;
    private APizzaInformations storeInformation;

    public AbstractPizzaStore(APizzaInformations storeInformation)
    {
        this.storeInformation=storeInformation;
        initializer();
    }

    public void orderPizza(int pizzaTypeIndex)
    {

    }
    protected abstract  void orderPizza(PizzaType pizzaType);

    private void initializer()
    {
        availablePizzaTypes = storeInformation.getAvailablePizzas();
        ingredientOfPizzas= storeInformation.getIngredientsOfPizzas();
        costOfPizzas=storeInformation.getCostOfPizzas();

        availableToppings=storeInformation.getAvailableToppings();
        costOfToppings=storeInformation.getCostOfToppings();
    }

}
