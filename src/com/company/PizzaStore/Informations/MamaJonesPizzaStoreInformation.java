package com.company.PizzaStore.Informations;
import com.company.IPizzaStorePizzaInformation;
import com.company.IPizzaStoreToppingsInformation;

import java.util.List;

public class MamaJonesPizzaStoreInformation extends APizzaInformations {





    public MamaJonesPizzaStoreInformation() {
        super(List.of(MamaJonesPizzaInformation.values()), List.of(MamaJonesToppingsInformation.values()));
    }


    private enum MamaJonesToppingsInformation implements IPizzaStoreToppingsInformation {
        Parmesan_Cheese(5),Olive(3),Ricotta_Chesee(5),Sausage(7),Pepperoni(7),Salami(8)
        ,Basil_Leaves(7),Cherry_Tomato(7),Jalapeno(4);

        private MamaJonesToppingsInformation(int cost) {
            this.cost = cost;
        }

        private int cost;
        public int getCost() {
            return cost;
        }
    }


   private enum MamaJonesPizzaInformation implements IPizzaStorePizzaInformation {
        Margherita(5,"Tomato_Sauce, Mozzarella_Cheese, Cherry_Tomato, Basil_Leaves"),
        Aegean(55,"Tomato Sauce, Mozzarella Cheese, Olive, Red Onion, Red Pepper"),
        Mixed(63,"Tomato Sauce, Mozzarella Cheese, Pepperoni, Sausage, Salami, Green Pepper"),
        Barbeque_Chicken(68,"Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque Sauce, Jalapeno"),
        Smoked_Ribs(72,"Tomato Sauce, Mozzarella Cheese, Smoked Ribs, Arugula Leaves, Parmesan Cheese")
       ;

        private int cost;
        private String ingredients;

        public int getCost() {
            return cost;
        }

        public String getIngeridients() {
            return ingredients;
        }

        private MamaJonesPizzaInformation(int cost, String ingredientList){
            this.cost = cost;
            this.ingredients = ingredientList;
        }


   }
}
