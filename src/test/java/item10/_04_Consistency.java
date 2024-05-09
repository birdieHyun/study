package item10;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class _04_Consistency {

    @Test
    @DisplayName("uri 일관성 위배")
    void test2() throws MalformedURLException {
        // 같은 도메인이지만 도메인이 가리키는 IP 값은 달라질 수 있음 -> 일관성 위배 가능성이 있음
        // host를 기준으로 비교하는게 아닌, 실제 IP를 가져와서 값을 비교함
        URL google1 = new URL("https", "about.google", "/products");
        URL google2 = new URL("https", "about.google", "/products");
        System.out.println(google1.equals(google2));
    }
}
