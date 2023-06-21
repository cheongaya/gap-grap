package com.roovalant.practice.tdd.money;

public abstract class Money {
    protected int amount; // 하위 클래스에서도 변수를 볼 수 있도록 private -> protected 로 변경
    protected String currency;

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }

    abstract Money times(int multiplier);

    String currency(){
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        System.out.println("getClass() : " + getClass());
        System.out.println("money.getClass() : " + money.getClass());
        return amount == money.amount
                && getClass().equals(money.getClass());
    }
}
