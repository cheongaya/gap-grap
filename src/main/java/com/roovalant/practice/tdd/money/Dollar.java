package com.roovalant.practice.tdd.money;

public class Dollar extends Money {

    private String currency;
    Dollar(int amount) {
        this.amount = amount;
        currency = "USD";
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
        return new Dollar(amount * multiplier);
    }

//    @Override
//    public boolean equals(Object obj) {
////        return true;
//        Dollar dollar = (Dollar) obj;
//        return amount == dollar.amount;
//    }
}
