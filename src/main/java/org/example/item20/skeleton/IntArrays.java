package org.example.item20.skeleton;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IntArrays {

    static List<Integer> intArrayAsList(int[] a) {

        Objects.requireNonNull(a);

        // 다이아몬드 연산자를 이렇게 사용하는건 자바 9부터 가능하다.
        return new AbstractList<>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public Integer set(int index, Integer element) {
                int oldVal = a[index];
                a[index] = element; // 오토언박싱
                return oldVal; // 오토박싱
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        List<Integer> list = intArrayAsList(a);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
