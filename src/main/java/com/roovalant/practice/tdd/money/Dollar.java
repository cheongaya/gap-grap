package com.roovalant.practice.tdd.money;

public class Dollar extends Money {

    private String currency;
    Dollar(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

//    Dollar times(int multiplier) {
////        amount = 5 * 2;
////        amount = amount * multiplier; // 원래는 5 * 2 => 중복제거 (리팩토링)
//
////        amount *= multiplier;
////        return null;
//
//        return new Dollar(amount * multiplier);
//    }

    Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

//    @Override
//    public boolean equals(Object obj) {
////        return true;
//        Dollar dollar = (Dollar) obj;
//        return amount == dollar.amount;
//    }
}
