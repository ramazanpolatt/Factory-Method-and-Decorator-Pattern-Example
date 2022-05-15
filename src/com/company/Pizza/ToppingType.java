package com.company.Pizza;

public enum ToppingType {
    BASIL_LEAVES("basil leaves"),SALAMI("salami"),CHERRY_TOMATO("cherry tomato"),
    JALAPENO("jalapeno"),MUSHROOM("mushroom"),OLIVE("olive"),RED_PEPPER("red pepper"),
    PARMESAN_CHEESE("parmesan cheese"),PASTRAMI("pastrami"),RICOTTA_CHEESE("ricotta cheese"),
    PEPPERONI("pepperoni"),SAUSAGE("sausage");

    private String readableNames;

    ToppingType(String readableNames) {
        this.readableNames = readableNames;
    }
    public String getReadableNames()
    {

        return  readableNames;
    }
}
