package com.company.PizzaStore.Informations;

import com.company.Interfaces.IPizzaStorePizzaInformation;
import com.company.Interfaces.IPizzaStoreToppingsInformation;

import java.util.List;

public class PizzaGlobalePizzaStoreInformation extends APizzaInformations {

    public PizzaGlobalePizzaStoreInformation() {
        super(List.of(PizzaGlobalePizzaInformations.values()), List.of(PizzaGlobaleToppingInformantions.values()));
    }

    private enum PizzaGlobaleToppingInformantions implements IPizzaStoreToppingsInformation{
        PARMESAN_CHEESE(5),OLIVE(4),SWEET_CORN(3),RICOTTA_CHEESE(4),RED_PEPPER(8),SAUSAGE(9),PEPPERONI(8),PASTRAMI(10),
        SALAMI(9),BASIL_LEAVES(6),CHERRY_TOMATO(7),MUSHROOM(4);

        private PizzaGlobaleToppingInformantions(int cost) {
            this.cost = cost;
        }

        private int cost;
        public int getCost() {
            return cost;
        }
    }

    private enum PizzaGlobalePizzaInformations implements IPizzaStorePizzaInformation{
        GOAT_CHEESE(60,"Tomato_Sauce, Mozzarella_Cheese, Salami, Mushroom"),
        MARGHERITA(60,"Tomato Sauce, Mozzarella Cheese, Cherry Tomato, Basil Leaves"),
        FOUR_CHEESES(55,"Tomato Sauce, Mozzarella Cheese, Roquefort Cheese, Parmesan Cheese, Feta Cheese"),
        BARBEQUE_CHICKEN(54,"Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque Sauce"),
        SMOKED_RIBS(70,"Tomato Sauce, Mozzarella Cheese, Smoked Ribs, Arugula Leaves, Parmesan Cheese");

        PizzaGlobalePizzaInformations(int cost, String ingredients) {
            this.cost = cost;
            this.ingredients = ingredients;
        }

        private int cost;
        private String ingredients;

        @Override
        public int getCost() {
            return cost;
        }

        @Override
        public String getIngredients() {
            return ingredients;
        }
    }

}
