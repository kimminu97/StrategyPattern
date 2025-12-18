package com.pattern.strategypattern;

public class FixedDiscountStrategy implements DiscountStrategy {
    private final int amount; // 예: 3000

    public FixedDiscountStrategy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        this.amount = amount;
    }

    @Override
    public int discount(int originPrice) {
        if (originPrice < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }
        // 할인금액이 원가를 넘지 않게
        return Math.min(amount, originPrice);
    }

    @Override
    public String toString() {
        return "FixedDiscountStrategy(" + amount + ")";
    }
}
