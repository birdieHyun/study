package item6.stringex;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CacheEx {

    @Test
    @DisplayName("Optional.empty")
    void test() {
        System.out.println(Optional.empty() == Optional.empty());
    }

    @Test
    @DisplayName("char test")
    void test2() {
        System.out.println(Character.valueOf((char) 127));


        System.out.println(Character.valueOf((char) -1) == Character.valueOf((char) -1));
        System.out.println(Character.valueOf((char) 0) == Character.valueOf((char) 0));
        System.out.println(Character.valueOf((char) 127) == Character.valueOf((char) 127));
        System.out.println(Character.valueOf((char) 128) == Character.valueOf((char) 128));
    }
}
