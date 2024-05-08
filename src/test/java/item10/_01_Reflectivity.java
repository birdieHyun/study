package item10;

import java.sql.Timestamp;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class _01_Reflectivity {

    @Test
    @DisplayName("반사성 reflectivity test")
    void reflectivity() {
        Point point = new Point(1, 2);
        System.out.println(point.equals(point));
    }

    @Test
    @DisplayName("Timestamp는 Datetime을 상속받았다.")
    void test() {
        long time = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(time);
        Date date = new Date(time);

        System.out.println(date.equals(timestamp)); // true
        System.out.println(timestamp.equals(date)); // false
    }

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }

            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
}
