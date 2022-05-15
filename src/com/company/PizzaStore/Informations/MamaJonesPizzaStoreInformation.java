package com.company.PizzaStore.Informations;
import com.company.Interfaces.IPizzaStorePizzaInformation;
import com.company.Interfaces.IPizzaStoreToppingsInformation;

import java.util.List;

public class MamaJonesPizzaStoreInformation extends APizzaInformations {





    public MamaJonesPizzaStoreInformation() {
        super(List.of(MamaJonesPizzaInformation.values()), List.of(MamaJonesToppingsInformation.values()));
    }




    private enum MamaJonesToppingsInformation implements IPizzaStoreToppingsInformation {
        PARMESAN_CHEESE(5),OLIVE(3),RICOTTA_CHEESE(5),SAUSAGE(7),PEPPERONI(7),SALAMI(8)
        ,BASIL_LEAVES(7),CHERRY_TOMATO(7),JALAPENO(4);

        private MamaJonesToppingsInformation(int cost) {
            this.cost = cost;
        }

        private int cost;
        public int getCost() {
            return cost;
        }
    }


   private enum MamaJonesPizzaInformation implements IPizzaStorePizzaInformation {
       MARGHERITA(58,"Tomato_Sauce, Mozzarella_Cheese, Cherry_Tomato, Basil_Leaves"),
       AEGEAN(55,"Tomato Sauce, Mozzarella Cheese, Olive, Red Onion, Red Pepper"),
       MIXED(63,"Tomato Sauce, Mozzarella Cheese, Pepperoni, Sausage, Salami, Green Pepper"),
       BARBEQUE_CHICKEN(68,"Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque Sauce, Jalapeno"),
       SMOKED_RIBS(72,"Tomato Sauce, Mozzarella Cheese, Smoked Ribs, Arugula Leaves, Parmesan Cheese")
       ;

        private int cost;
        private String ingredients;

        public int getCost() {
            return cost;
        }

        public String getIngredients() {
            return ingredients;
        }

        private MamaJonesPizzaInformation(int cost, String ingredientList){
            this.cost = cost;
            this.ingredients = ingredientList;
        }


   }
}
