package com.pattern.strategypattern;

import java.math.BigDecimal;

public class PaymentService {

    private final DiscountStrategy discountStrategy;

    public PaymentService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * @param originPrice 원가
     * @return 최종 결제 금액
     */
    public BigDecimal pay(BigDecimal originPrice) {
        if (originPrice == null) {
            throw new IllegalArgumentException("originPrice must not be null");
        }
        if (originPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }

        BigDecimal discount = discountStrategy.discount(originPrice);
        BigDecimal finalPrice = originPrice.subtract(discount);

        // 방어(전략 구현이 잘못돼도 음수 방지)
        return finalPrice.max(BigDecimal.ZERO);
    }
}