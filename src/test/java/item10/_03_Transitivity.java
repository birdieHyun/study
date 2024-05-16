package item10;

import org.example.item10.equals.symmetry.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class _03_Transitivity {

    @Test
    @DisplayName("A -> B -> C 위배")
    void test() {
        ColorPoint colorPoint = new ColorPoint(1, 0, Color.RED);
        Point point = new Point(1, 0);
        ColorPoint colorPoint2 = new ColorPoint(1, 0, Color.BLUE);

        System.out.println(colorPoint.equals(point));
        System.out.println(point.equals(colorPoint));
        System.out.println(colorPoint.equals(colorPoint2));
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
            // 객체의 동일성 확인 -> 반사성
            if (this == o) {
                return true;
            }

            // 타입 비교
            if (!(o instanceof Point)) {
                return false;
            }

            // 형변환 후
            Point p = (Point) o;
            // 핵심적인 필드들만 비교 -> 부동소수점 영향 받는 애들은 Double.compare()로 비교해야함, reference type은 equals로 비교
            // primitive type만 ==으로 비교 , null도 허용한다면 Object.equals()가 null을 허용해줌
            return p.x == x && p.y == y;
        }
    }

    static class ColorPoint extends Point {

        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }

            // o가 일반 Point면 색상을 무시하고 비교한다.
            if (!(o instanceof ColorPoint)) {
                return o.equals(this);
            }

            // color point면 색상까지 비교한다.
            return super.equals(o) && ((ColorPoint) o).color == color;
        }
    }

    @Test
    @DisplayName("상속이 아닌 구성")
    void test3() {
        ColorPointComposition cp1 = new ColorPointComposition(1, 2, Color.RED);
        ColorPointComposition cp2 = new ColorPointComposition(1, 2, Color.BLUE);
        Point point = new Point(1, 2);

        System.out.println(cp1.equals(point));
        System.out.println(point.equals(cp2));
        System.out.println(cp1.equals(cp2));

        // 상속이었다면 추이성이 깨지지만, 구성을 사용했기 때문에 추이성에 문제가 없다.
        System.out.println(cp1.asPoint().equals(point));
        System.out.println(point.equals(cp2.asPoint()));
        System.out.println(cp1.asPoint().equals(cp2.asPoint()));
    }


    static class ColorPointComposition {

        private final Point point;
        private final Color color;

        public ColorPointComposition(int x, int y, Color color) {
            this.point = new Point(x, y);
            this.color = color;
        }

        public Point asPoint() {
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ColorPointComposition)) {
                return false;
            }
            ColorPointComposition cp = (ColorPointComposition) o;
            return cp.point.equals(point) && cp.color.equals(color);
        }
    }
}
