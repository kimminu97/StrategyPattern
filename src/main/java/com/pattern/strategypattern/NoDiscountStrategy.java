package com.pattern.strategypattern;

public class NoDiscountStrategy implements  DiscountStrategy{
    @Override
    public int discount(int originPrice) {
        if (originPrice < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }
        return 0;
    }

    @Override
    public String toString() {
        return "NoDiscountStrategy";
    }
}
