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

        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == d);
        System.out.println(a == c);
        System.out.println(b == d);
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
    void test5() {
        long startTime = System.currentTimeMillis();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 100_000; i++) {
            result.append("hello");
        }
        long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) + "ms");
    }


}
