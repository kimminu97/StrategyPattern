package com.pattern.strategypattern;

import java.math.BigDecimal;

public class FixedDiscountStrategy implements DiscountStrategy {
    private final BigDecimal amount; // 예: 3000

    public FixedDiscountStrategy(BigDecimal amount) {
        if ( amount.compareTo(BigDecimal.ZERO)  < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        this.amount = amount;
    }

    @Override
    public BigDecimal discount(BigDecimal originPrice) {
        if (originPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }

        // 할인금액이 원가를 넘지 않게 방어
        return amount.min(originPrice);
    }

    @Override
    public String toString() {
        return "FixedDiscountStrategy(" + amount + ")";
    }
}
