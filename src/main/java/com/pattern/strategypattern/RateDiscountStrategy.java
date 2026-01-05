package com.pattern.strategypattern;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RateDiscountStrategy implements DiscountStrategy {

    private static final BigDecimal HUNDRED = new BigDecimal("100");

    private final BigDecimal ratePercent; // 예: 10 = 10%

    public RateDiscountStrategy(BigDecimal ratePercent) {
        if (ratePercent == null) {
            throw new IllegalArgumentException("ratePercent must not be null");
        }
        if (ratePercent.compareTo(BigDecimal.ZERO) < 0
                || ratePercent.compareTo(HUNDRED) > 0) {
            throw new IllegalArgumentException("ratePercent must be between 0 and 100");
        }
        this.ratePercent = ratePercent;
    }

    @Override
    public BigDecimal discount(BigDecimal originPrice) {
        if (originPrice == null) {
            throw new IllegalArgumentException("originPrice must not be null");
        }
        if (originPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }

        // originPrice * ratePercent / 100
        return originPrice
                .multiply(ratePercent)
                .divide(HUNDRED, 0, RoundingMode.DOWN);
    }

    @Override
    public String toString() {
        return "RateDiscountStrategy(" + ratePercent + "%)";
    }
}
