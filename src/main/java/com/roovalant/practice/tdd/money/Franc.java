package com.roovalant.practice.tdd.money;

public class Franc extends Money {

    private String currency;
    Franc(int amount) {
        this.amount = amount;
        currency = "CHF";
    }

//    Franc times(int multiplier) {
//        return new Franc(amount * multiplier);
//    }
    Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

//    @Override
//    public boolean equals(Object obj) {
//        Franc franc = (Franc) obj;
//        return amount == franc.amount;
//    }
}
