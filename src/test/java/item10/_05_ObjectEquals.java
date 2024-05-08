package item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class _05_ObjectEquals {

    @Test
    @DisplayName("equals 메서드 오버로딩")
    void test() {
        List<Point> points = new ArrayList<>();

        Point p1 = new Point(1, 2);

        points.add(p1);
        System.out.println(points.contains(new Point(1, 2)));
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

//        @Override
        public boolean equals(Point o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) {
//                return true;
//            }
//            if (o == null || getClass() != o.getClass()) {
//                return false;
//            }
//            Point point = (Point) o;
//            return x == point.x && y == point.y;
//        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
