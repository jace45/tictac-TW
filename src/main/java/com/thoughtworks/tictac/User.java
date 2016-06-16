package com.thoughtworks.tictac;

public class User {

    private String name;
    private String symbol;

    public User(String name, String symbol) {

        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {

        return name;
    }
//
//    public void chooseLocation() {
//    }

    public String getSymbol() {
        return symbol;
    }
}
