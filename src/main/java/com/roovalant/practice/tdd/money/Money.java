package com.roovalant.practice.tdd.money;

public class Money {
    protected int amount; // 하위 클래스에서도 변수를 볼 수 있도록 private -> protected 로 변경
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    String currency(){
        return currency;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        System.out.println("getClass() : " + getClass());
        System.out.println("money.getClass() : " + money.getClass());
//        return amount == money.amount
//                && getClass().equals(money.getClass());
        return amount == money.amount
                && currency().equals(money.currency());
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
