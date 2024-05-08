package item10;

import org.example.item10.equals.symmetry.Color;
import org.junit.jupiter.api.Test;

class _06_StackOverflow {

    @Test
    void test() {
        SmellPoint sp = new SmellPoint(1, 2, "good");
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(sp.equals(cp));
    }

    static class SmellPoint extends Point {

        private String smell;

        public SmellPoint(int x, int y, String smell) {
            super(x, y);
            this.smell = smell;
        }

        @Override
        public boolean equals(Object o) {

            if (!(o instanceof Point)) {
                return false;
            }

            // 만약 ColorPoint를 equals로 받게 된다면?
            // colorPoint equals smellPoint -> 계속 재귀적으로 서로를 equals를 부르게 됨
            if (!(o instanceof SmellPoint)) {
                return o.equals(this);
            }

            return super.equals(o) && ((SmellPoint) o).smell.equals(smell);
        }
    }

    static class ColorPoint extends Point{

        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        public boolean equals(Object o) { // 대칭성 준수
            if (!(o instanceof Point)) {
                return false;
            }

            // o가 일반 Point면 색상을 무시하고 비교한다.
            if (!(o instanceof ColorPoint)) {
                return o.equals(this);
            }

            return super.equals(o) && ((ColorPoint) o).color == color;
        }
    }

    static class Point {

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
}
