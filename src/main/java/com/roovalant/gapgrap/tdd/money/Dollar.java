package com.roovalant.gapgrap.tdd.money;

public class Dollar {
    int amount;
    Dollar(int amount) {
        this.amount = amount;
    }

    void times(int multiplier) {
//        amount = 5 * 2;
        amount = amount * multiplier; // 원래는 5 * 2 => 중복제거 (리팩토링)
    }
}
