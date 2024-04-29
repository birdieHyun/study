package item6.stringex;

import org.junit.jupiter.api.Test;

class StringExample {

    @Test
    void test() {
        String literal = "literal";
        String literal2 = new String("literal");
        String literal3 = "literal";

        System.out.println(literal == literal2);
        System.out.println(literal == literal3);
        System.out.println(literal2 == literal3);
    }

    @Test
    void test2() {
        String a = "helloworld";
        String b = "hello" + "world";

        System.out.println(a == b);
    }

    @Test
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

//        System.out.println("result = " + result);
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

//        System.out.println("result = " + result);
        System.out.println((endTime - startTime) + "ms");
    }
}
