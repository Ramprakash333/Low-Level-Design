package com.splitwise.models;

public class Amount {
    private final Currency currency;
    private final double amount;
    
    public Amount(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Amount add(Amount amount) {
        return new Amount(currency, this.amount + amount.amount);
    }

    public double getAmount() {
        return amount;
    }

}
