package com.pattern.strategypattern;

import java.math.BigDecimal;

public class NoDiscountStrategy implements  DiscountStrategy{
    @Override
    public BigDecimal discount(BigDecimal originPrice) {
        if (originPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "NoDiscountStrategy";
    }
}
