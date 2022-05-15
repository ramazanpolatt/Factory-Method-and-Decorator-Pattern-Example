package com.company.Pizza;

public enum ToppingType
{

  BASIL_LEAVES("Basil Leaves"),SALAMI("Salami"),CHERRY_TOMATO("Cherry Tomato"),
  JALAPENO("Jalapeno"),MUSHROOM("Mushroom"),OLIVE("Olive"),RED_PEPPER("Red Pepper"),
  PARMESAN_CHEESE("Parmesan Cheese"),PASTRAMI("Pastrami"),RICOTTA_CHEESE("Ricotta Cheese"),
  PEPPERONI("Pepperoni"),SAUSAGE("Sausage"),SWEET_CORN("Sweet Corn");

  private String readableNames;

  ToppingType(String readableNames) {
    this.readableNames = readableNames;
  }
  public String getReadableNames()
  {

    return  readableNames;
  }
}