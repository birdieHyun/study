package item8.finalizercleaner;

import org.example.item8.finalizer.Account;
import org.example.item8.finalizer.AccountHacking;
import org.junit.jupiter.api.Test;

class FinalizerTest {

    @Test
    void test() throws InterruptedException {
        Account putin = null;

        try {
            putin = new AccountHacking("푸틴");
        } catch (Exception e) {
            System.out.println("푸틴은 계좌를 가질 수 없습니다.");
        }
        System.gc();
        Thread.sleep(3000L);
    }

    @Test
    void test2() throws InterruptedException {
        Account account = new AccountHacking("홍길동");

        account = null;
        System.gc();
        Thread.sleep(3000L);
    }
}
