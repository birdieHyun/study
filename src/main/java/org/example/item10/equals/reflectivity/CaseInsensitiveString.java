package org.example.item10.equals.reflectivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
//    public boolean equals(Object o) {
//
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//        if (o instanceof String){
//            return s.equalsIgnoreCase((String) o);
//        }
//
//        return false;
//    }
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
            ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

    public static void main(String[] args) {
        // 반사성
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        System.out.println(cis.equals(cis));

        // 대칭성 위배
        CaseInsensitiveString s1 = new CaseInsensitiveString("s");
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(s1);

        System.out.println(s1.equals("s"));
        System.out.println("s".equals(s1));
        System.out.println(list.contains("s"));

        // 대칭성 준수
        CaseInsensitiveString s2 = new CaseInsensitiveString("s");
        CaseInsensitiveString s3 = new CaseInsensitiveString("s");
        System.out.println(s2.equals(s3));
        System.out.println(s3.equals(s2));
    }
}
