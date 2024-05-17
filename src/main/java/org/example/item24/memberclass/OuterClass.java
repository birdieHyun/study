package org.example.item24.memberclass;

import java.math.BigDecimal;

public class OuterClass {

    private int number = 10;

    private class InnerClass{ // 암묵적으로 바깥 클래스에 대한 참조가 생김 -> OuterCLass 없이는 InnerClass를 생성할 수 없다.
        void doSomething() {
            System.out.println(number);
            System.out.println(OuterClass.this.number); // 이런식으로 내부에서 외부를 참조할 수 있다.
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.doSomething();

        BigDecimal bigDecimal = new BigDecimal("1");
    }
}
