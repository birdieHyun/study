package item6.stringex;

import org.junit.jupiter.api.Test;

class NumberCache {

    @Test
    void integerCache() {
        Integer a = Integer.valueOf("1");
        Integer b = Integer.valueOf("1");

        Integer c = Integer.valueOf("12341234");
        Integer d = Integer.valueOf("12341234");

        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    void longCache() {
        Long a = Long.valueOf("1");
        Long b = Long.valueOf("1");
        Integer z = Integer.valueOf("1");

        Long c = Long.valueOf("12341234");
        Long d = Long.valueOf("12341234");

        System.out.println(a == b);
        System.out.println(c == d);

        System.out.println(a.equals(z));
    }

    @Test
    void doubleCache() {
        Double a = Double.valueOf("1");
        Double b = Double.valueOf("1");

        Double c = Double.valueOf("12341234");
        Double d = Double.valueOf("12341234");

        System.out.println(a == b);
        System.out.println(c == d);
    }
}
