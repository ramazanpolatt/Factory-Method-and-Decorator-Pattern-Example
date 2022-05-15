package com.company.PizzaStore.Informations;

import com.company.IPizzaStorePizzaInformation;
import com.company.IPizzaStoreToppingsInformation;

import java.util.List;

public class PizzaHatPizzaStoreInformation extends APizzaInformations{


    public PizzaHatPizzaStoreInformation() {
        super(List.of(PizzaHatPizzaInformation.values()), List.of(PizzaStoreToppingsInformation.values()));
    }



    private enum PizzaStoreToppingsInformation implements IPizzaStoreToppingsInformation {
        PARMESAN_CHEESE(5),OLIVE(3),RICOTTA_CHEESE(5),SAUSAGE(7),PEPPERONI(7),SALAMI(8)
        ,BASIL_LEAVES(7),CHERRY_TOMATO(7),JALAPENO(4);

        private PizzaStoreToppingsInformation(int cost) {
            this.cost = cost;
        }

        private int cost;
        public int getCost() {
            return cost;
        }
    }


    private enum PizzaHatPizzaInformation implements IPizzaStorePizzaInformation {
        RANCH_HOUSE(50,"Tomato_Sauce, Mozzarella_Cheese, Salami, Mushroom"),
        MARGHERITA(53,"Tomato_Sauce, Mozzarella_Cheese, Cherry_Tomato, Basil_Leaves"),
        PEPPERONI(63,"Tomato_Sauce, Mozzarella_Cheese, Pepperoni"),
        BARBEQUE_CHICKEN(68,"Tomato_Sauce, Mozzarella_Cheese, Chicken_Slices, Barbeque_Sauce"),

        ;

        private int cost;
        private String ingredients;

        public int getCost() {
            return cost;
        }

        public String getIngredients() {
            return ingredients;
        }

        private PizzaHatPizzaInformation(int cost, String ingredientList){
            this.cost = cost;
            this.ingredients = ingredientList;
        }


    }
}
