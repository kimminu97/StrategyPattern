package com.pattern.strategypattern;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        int originPrice = 10_000;

        // 1. 비율 할인 (10%)
        PaymentService rateDiscountPayment =
                new PaymentService(new RateDiscountStrategy(10));
        System.out.println("Rate 10% discount: "
                + rateDiscountPayment.pay(originPrice)); // 9000

        // 2. 정액 할인 (3000원)
        PaymentService fixedDiscountPayment =
                new PaymentService(new FixedDiscountStrategy(3_000));
        System.out.println("Fixed 3000 discount: "
                + fixedDiscountPayment.pay(originPrice)); // 7000

        // 3. 할인 없음
        PaymentService noDiscountPayment =
                new PaymentService(new NoDiscountStrategy());
        System.out.println("No discount: "
                + noDiscountPayment.pay(originPrice)); // 10000
    }
}