package com.pattern.strategypattern;

public interface DiscountStrategy {
    /**
     * @param originPrice 원가(정수, 예: 10000)
     * @return 할인 금액(정수)
     */
    int discount(int originPrice);
}
