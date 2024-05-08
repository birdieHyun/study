package item9;

import java.io.IOException;
import org.example.item9.trywitresource.BadBufferedReaderEx;
import org.example.item9.trywitresource.GoodBufferedReaderEx;
import org.junit.jupiter.api.Test;

class TwoErrorProblem {

    @Test
    void test() throws IOException {
        // readline의 예외가 콘솔에서 사라지는 문제 발생
        System.out.println(BadBufferedReaderEx.firstLineOfFile());
    }

    @Test
    void test2() throws IOException {
        System.out.println(GoodBufferedReaderEx.firstLineOfFile());
    }
}
