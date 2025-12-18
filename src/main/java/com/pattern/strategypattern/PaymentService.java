package com.pattern.strategypattern;

public class PaymentService {
    private final DiscountStrategy discountStrategy;

    public PaymentService(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * @param originPrice 원가
     * @return 최종 결제 금액
     */
    public int pay(int originPrice) {
        if (originPrice < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }

        int discount = discountStrategy.discount(originPrice);
        int finalPrice = originPrice - discount;

        // 방어(전략 구현이 잘못돼도 음수 방지)
        return Math.max(finalPrice, 0);
    }
}
