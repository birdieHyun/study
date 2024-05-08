package org.example.item10.equals.symmetry;

public class ColorPoint extends Point{

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) { // 대칭성 위배
        if (!(o instanceof ColorPoint)){
            return false;
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
//    public boolean equals(Object o) { // 대칭성 준수
//        if (!(o instanceof Point)) {
//            return false;
//        }
//
//        // o가 일반 Point면 색상을 무시하고 비교한다.
//        if (!(o instanceof ColorPoint)) {
//            return o.equals(this);
//        }
//
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(p1.equals(cp));
        System.out.println(cp.equals(p1));
    }
}
