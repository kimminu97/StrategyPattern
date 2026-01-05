package com.pattern.strategypattern;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        BigDecimal originPrice = new BigDecimal("10000");

        // 1. 비율 할인 (10%)
        PaymentService rateDiscountPayment =
                new PaymentService(
                        new RateDiscountStrategy(new BigDecimal("10"))
                );

        System.out.println(
                "Rate 10% discount: "
                        + rateDiscountPayment.pay(originPrice) // 9000
        );

        // 2. 정액 할인 (3000원)
        PaymentService fixedDiscountPayment =
                new PaymentService(
                        new FixedDiscountStrategy(new BigDecimal("3000"))
                );

        System.out.println(
                "Fixed 3000 discount: "
                        + fixedDiscountPayment.pay(originPrice) // 7000
        );

        // 3. 할인 없음
        PaymentService noDiscountPayment =
                new PaymentService(new NoDiscountStrategy());

        System.out.println(
                "No discount: "
                        + noDiscountPayment.pay(originPrice) // 10000
        );
    }
}
