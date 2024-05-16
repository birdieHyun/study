package item6.stringex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringExample {

    @Test
    void intern() {
        String a = new String("hello");
        String b = "hello";
        String c = a.intern();
        String d = b.intern();

        System.out.println(a == b); // false false false
        System.out.println(b == c); // false true false
        System.out.println(c == d); // true true false
        System.out.println(a == c); // false false true
        System.out.println(b == d); // true true true
    }

    @Test
    @DisplayName("String pool test")
    void test2() {
        String a = "helloworld";
        String b = "hello" + "world";

        System.out.println(a == b);
    }

    @Test
    @DisplayName("String pool test")
    void test3() {
        String a = "hello";
        String b = "world";
        String c = a + b;

        System.out.println(c == "helloworld");
    }

    @Test
    @DisplayName("String + test")
    void test4() {
        long startTime = System.currentTimeMillis();
        String result = "";

        for (int i = 0; i < 100_000; i++) {
            result += "hello";
        }
        long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) + "ms");
    }

    @Test
    @DisplayName("StringBuilder test")
    void test5() {
        long startTime = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 100_000; i++) {
            result.append("hello");
        }
        long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) + "ms");
    }

    public static void main(String[] args) {

        int a = 1;
        long b = 2;

        long c = b + a;
    }

}
