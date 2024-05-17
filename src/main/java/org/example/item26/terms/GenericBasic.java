package org.example.item26.terms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericBasic {

    public static void main(String[] args) {
        // Generic 사용하기 전
        List numbers = new ArrayList();
        numbers.add(10);
//        numbers.add("whiteship"); // 컴파일 시점에 알 수 없고

        for (Object number : numbers) {
            System.out.println((Integer) number); // 런타임 시점에 잘못된 것을 알 수 있음
        }

        // Generic 등장 이후
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
//        nums.add("whiteship"); // 컴파일 에러

        nums.forEach(System.out::println);

        Set<?> a = new HashSet<>();
//        a.add(10);
//        a.add("whiteship");
//        a.add(null);

        List b = new ArrayList();
        b.add(10);
        b.add("whiteship");
        b.add(new Date());

        Object o = b.get(0);
        Object o1 = b.get(1);
        System.out.println(b.get(2));

        List<Object> c = new ArrayList<>();
        c.add(10);
        c.add("whiteship");
        c.add(new Date());

        Object o2 = c.get(0);
        Object o3 = c.get(1);
        System.out.println(c.get(2));
    }

}
