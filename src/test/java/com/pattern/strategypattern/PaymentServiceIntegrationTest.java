package com.pattern.strategypattern;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class PaymentServiceIntegrationTest {

    @Test
    void 고정할인전략_적용() {
        PaymentService service =
                new PaymentService(new FixedDiscountStrategy(new BigDecimal("1000")));

        assertBigDecimalEquals("9000", service.pay(new BigDecimal("10000")));
    }

    @Test
    void 비율할인전략_적용() {
        PaymentService service =
                new PaymentService(new RateDiscountStrategy(new BigDecimal("10"))); // 10%

        assertBigDecimalEquals("9000", service.pay(new BigDecimal("10000")));
    }

    private static void assertBigDecimalEquals(String expected, BigDecimal actual) {
        BigDecimal exp = new BigDecimal(expected);
        if (exp.compareTo(actual) != 0) {
            throw new AssertionError("expected=" + exp + ", actual=" + actual);
        }
    }
}
