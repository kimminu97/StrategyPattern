# Strategy Pattern Practice - Payment Discount

## Goal
JDBC 예제가 아닌, 일상적인 도메인(결제/할인)을 통해 **Strategy Pattern**을 손으로 구현하고,
“변하는 것(할인 정책)”과 “변하지 않는 것(결제 흐름)”을 분리했을 때 얻는 장점을 체감한다.

---

## What is Strategy Pattern?
Strategy Pattern은 **변하는 알고리즘(전략)을 객체로 분리**하여,
실행 시점(runtime)에 교체 가능하게 만드는 설계 패턴이다.

- **Context**: 변하지 않는 흐름(프로세스)을 담당
- **Strategy**: 변하는 동작(알고리즘)을 캡슐화한 인터페이스
- **ConcreteStrategy**: 실제 전략 구현체
- **Client**: 어떤 전략을 쓸지 선택하고 Context에 주입

---

## Intent (Why use it?)
이 예제에서 “할인 계산 로직”은 정책에 따라 바뀔 수 있다.
반면 “결제 최종 금액을 계산하는 흐름”은 상대적으로 안정적이다.

Strategy Pattern을 적용하면:
- 할인 정책 추가/변경 시 **Context 수정 없이 확장 가능**
- 조건 분기(if/else) 확장을 줄이고, 변경 범위를 전략 객체로 한정
- 테스트에서 각 전략을 독립적으로 검증 가능

---

## Design
### Roles
- **DiscountStrategy**: 할인 계산 알고리즘의 계약(Strategy)
- **RateDiscountStrategy**: 비율 할인(ConcreteStrategy)
- **FixedDiscountStrategy**: 정액 할인(ConcreteStrategy)
- **NoDiscountStrategy**: 할인 없음(ConcreteStrategy)
- **PaymentService**: 결제 흐름을 담당(Context)

---

## Class Diagram (text UML)
                 <<interface>>
               DiscountStrategy
               + discount(price): int
                      ▲
     ┌────────────────┼─────────────────┐
     │                │                 │
RateDiscountStrategy  FixedDiscountStrategy  NoDiscountStrategy
- ratePercent:int     - amount:int           (no fields)
+ discount(price):int + discount(price):int  + discount(price):int


                 PaymentService  <<Context>>
                 - strategy: DiscountStrategy
                 + pay(originPrice:int): int
                        |
                        | uses
                        v
               DiscountStrategy.discount()

