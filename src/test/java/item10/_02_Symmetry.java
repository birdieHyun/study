package item10;

import org.example.item10.equals.symmetry.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class _02_Symmetry {

    @Test
    @DisplayName("A -> B")
    void test() {
        CaseInsensitiveString cis = new CaseInsensitiveString("test");
        String string = new String("test");

        System.out.println(cis.equals(string));
    }

    @Test
    @DisplayName("B -> A")
    void test2() {
        CaseInsensitiveString cis = new CaseInsensitiveString("test");
        String string = new String("test");

        System.out.println(string.equals(cis));
    }

    @Test
    @DisplayName("Point equals")
    void test3(){
        Point point = new Point(1, 2);
        ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);

        System.out.println(point.equals(colorPoint));
    }

    @Test
    @DisplayName("ColorPoint equals")
    void test4(){
        Point point = new Point(1, 2);
        ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);

        System.out.println(colorPoint.equals(point));
    }

    static class CaseInsensitiveString{
        private final String s;

        public CaseInsensitiveString(String s) {
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {

            if (o instanceof CaseInsensitiveString) { // object가 case insensitive string일 경우
                return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
            }
            if (o instanceof String){ // object가 string일 경우 -> CaseInsensitiveString을 String과 마찬가지로 생각하겠다.
                return s.equalsIgnoreCase((String) o);
            }

            return false;
        }
    }

    static class Point{
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {

            if (!(o instanceof Point)) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }

    static class ColorPoint extends Point{

        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ColorPoint)){
                return false;
            }
            return super.equals(o) && ((ColorPoint) o).color == color;
        }
    }

}
