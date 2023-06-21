package com.roovalant.practice.tdd.money;

public class Franc extends Money {

    private String currency;
    Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

//    Franc times(int multiplier) {
//        return new Franc(amount * multiplier);
//    }
    Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }

//    @Override
//    public boolean equals(Object obj) {
//        Franc franc = (Franc) obj;
//        return amount == franc.amount;
//    }
}
