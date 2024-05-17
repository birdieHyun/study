package org.example.item24.staticmemberclass;

public class OuterClass {

    private static int number = 10;

    static private class InnerClass { // 바깥 클래스의 static 변수에 접근 가능 , 바깥 class의 인스턴스를 필요로 하지 않음 -> 바깥 클래스와 독립적이다.
        void doSomething() {
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.doSomething();
    }
}
