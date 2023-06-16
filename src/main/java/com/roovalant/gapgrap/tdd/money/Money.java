package com.roovalant.gapgrap.tdd.money;

public class Money {
    protected int amount; // 하위 클래스에서도 변수를 볼 수 있도록 private -> protected 로 변경

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount;
    }
}
