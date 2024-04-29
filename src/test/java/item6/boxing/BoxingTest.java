package item6.boxing;

import org.junit.jupiter.api.Test;

class BoxingTest {

    @Test
    void test() {
        Long start = System.currentTimeMillis();

        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += (Long) i;
        }
        Long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) + "ms");
    }

    @Test
    void test2() {
        long start = System.currentTimeMillis();

        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) + "ms");
    }

    @Test
    @Deprecated
    void test3() {
        Long start = System.currentTimeMillis();

        Long sum = 0L;
        long test = 0;
        int tmp = 1;
        while (tmp < Integer.MAX_VALUE) {
            tmp++;

            sum += test;
        }
        Long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) + "ms");
    }

    @Test
    void test4() {
        Long start = System.currentTimeMillis();

        long sum = 0L;
        Long test = 0L;
        int tmp = 1;
        while (tmp < Integer.MAX_VALUE) {
            tmp++;

            sum += test;
        }
        Long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) + "ms");
    }

}
