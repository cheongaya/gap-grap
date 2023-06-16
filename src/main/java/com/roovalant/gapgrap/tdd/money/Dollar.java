package com.roovalant.gapgrap.tdd.money;

public class Dollar extends Money {
    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
//        amount = 5 * 2;
//        amount = amount * multiplier; // 원래는 5 * 2 => 중복제거 (리팩토링)

//        amount *= multiplier;
//        return null;

        return new Dollar(amount * multiplier);
    }

//    @Override
//    public boolean equals(Object obj) {
////        return true;
//        Dollar dollar = (Dollar) obj;
//        return amount == dollar.amount;
//    }
}
