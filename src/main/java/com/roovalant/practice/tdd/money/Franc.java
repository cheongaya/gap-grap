package com.roovalant.practice.tdd.money;

public class Franc extends Money {
    Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

//    @Override
//    public boolean equals(Object obj) {
//        Franc franc = (Franc) obj;
//        return amount == franc.amount;
//    }
}
