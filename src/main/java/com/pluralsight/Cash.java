package com.pluralsight;

import java.math.BigDecimal;

public class Cash extends Asset {
    private int money;

    public Cash(String description, String dateAcquired, BigDecimal originalCost, int money) {
        super(description, dateAcquired, originalCost);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public abstract int getValue();
}
