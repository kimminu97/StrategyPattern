package com.pattern.strategypattern;

public class RateDiscountStrategy implements  DiscountStrategy{
    private final int ratePercent; // 예: 10 = 10%

    public RateDiscountStrategy(int ratePercent) {
        if (ratePercent < 0 || ratePercent > 100) {
            throw new IllegalArgumentException("ratePercent must be between 0 and 100");
        }
        this.ratePercent = ratePercent;
    }

    @Override
    public int discount(int originPrice) {
        if (originPrice < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }
        return originPrice * ratePercent / 100;
    }

    @Override
    public String toString() {
        return "RateDiscountStrategy(" + ratePercent + "%)";
    }
}
