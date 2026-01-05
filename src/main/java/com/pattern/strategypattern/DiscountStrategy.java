package com.pattern.strategypattern;

import java.math.BigDecimal;

public interface DiscountStrategy {
    /**
     * @param originPrice 원가(정수, 예: 10000)
     * @return 할인 금액(정수)
     */
    BigDecimal discount(BigDecimal originPrice);
}
