package item11;

import java.util.HashMap;
import java.util.Map;
import org.example.item11.hashCode.PhoneNumNoHashCode;
import org.junit.jupiter.api.Test;

class BadHashCode {

    @Test
    void test() {

        Map<PhoneNumNoHashCode, String> map = new HashMap<>();
        PhoneNumNoHashCode num1 = new PhoneNumNoHashCode(111, 222, 333);
        PhoneNumNoHashCode num2 = new PhoneNumNoHashCode(111, 222, 333);

        System.out.println(num1.equals(num2));

        System.out.println("num1 hash code : " + num1.hashCode());
        System.out.println("num2 hash code : " + num2.hashCode());

        map.put(num1, "whiteship");
        map.put(num2, "donghyun");

        System.out.println(map.get(num1));
        System.out.println(map.get(num2));
        System.out.println(map.get(new PhoneNumNoHashCode(111, 222, 333)));
    }
}
