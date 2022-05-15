package com.company.PizzaStore.Informations;

import Interfaces.IPizzaStorePizzaInformation;
import Interfaces.IPizzaStoreToppingsInformation;

import java.util.List;

public class PizzaHatPizzaStoreInformation extends APizzaInformations{


    public PizzaHatPizzaStoreInformation() {
        super(List.of(PizzaHatPizzaInformation.values()), List.of(PizzaStoreToppingsInformation.values()));
    }

    private enum PizzaStoreToppingsInformation implements IPizzaStoreToppingsInformation {
        Parmesan_Cheese(5),Olive(3),Ricotta_Chesee(5),Sausage(7),Pepperoni(7),Salami(8)
        ,Basil_Leaves(7),Cherry_Tomato(7),Jalapeno(4);

        private PizzaStoreToppingsInformation(int cost) {
            this.cost = cost;
        }

        private int cost;
        public int getCost() {
            return cost;
        }
    }


    private enum PizzaHatPizzaInformation implements IPizzaStorePizzaInformation {
        Ranch_House(50,"Tomato_Sauce, Mozzarella_Cheese, Salami, Mushroom"),
        Margherita(53,"Tomato_Sauce, Mozzarella_Cheese, Cherry_Tomato, Basil_Leaves"),
        Pepperoni(63,"Tomato_Sauce, Mozzarella_Cheese, Pepperoni"),
        Barbeque_Chicken(68,"Tomato_Sauce, Mozzarella_Cheese, Chicken_Slices, Barbeque_Sauce"),

        ;

        private int cost;
        private String ingredients;

        public int getCost() {
            return cost;
        }

        public String getIngeridients() {
            return ingredients;
        }

        private PizzaHatPizzaInformation(int cost, String ingredientList){
            this.cost = cost;
            this.ingredients = ingredientList;
        }


    }
}
