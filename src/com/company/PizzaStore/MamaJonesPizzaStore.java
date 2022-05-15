package com.company.PizzaStore;

import com.company.Pizza.PizzaType;
import com.company.Pizza.ToppingType;
import com.company.PizzaStore.Informations.APizzaInformations;
import com.company.PizzaStore.Informations.MamaJonesPizzaStoreInformation;

import java.util.List;
import java.util.Map;

public  class MamaJonesPizzaStore extends AbstractPizzaStore{
    public MamaJonesPizzaStore(APizzaInformations storeInformation) {
        super(storeInformation);
    }


    /*public MamaJonesPizzaStore()
    {


    }*/

    @Override
    protected void orderPizza(PizzaType pizzaType) {

    }
}
