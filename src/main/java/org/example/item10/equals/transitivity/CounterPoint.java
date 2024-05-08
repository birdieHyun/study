package org.example.item10.equals.transitivity;

import java.util.concurrent.atomic.AtomicInteger;
import org.example.item10.equals.symmetry.Point;

/**
 * equals를 재정의하지 않아서 Point의 equals를 사용
 */
public class CounterPoint extends Point {

    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int numberCreated() {
        return counter.get();
    }
}
