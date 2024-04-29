package item7.excecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.example.item7.executor.RunnableTask;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutorTest {

    @Test
    @DisplayName("스레드 생성 후 사용 ")
    void test() throws InterruptedException {

        int threadCount = 100;
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new RunnableTask(latch));
            thread.start();
        }

        latch.await();
    }

    @Test
    @DisplayName("fixed thread pool")
    void test2() throws InterruptedException {

        int threadCount = 100;
        CountDownLatch latch = new CountDownLatch(threadCount);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.submit(new RunnableTask(latch));
        }

        latch.await();
    }

    @Test
    @DisplayName("cached thread pool")
    void test3() throws InterruptedException {

        int threadCount = 100;
        CountDownLatch latch = new CountDownLatch(threadCount);

        // 최대 40개의 스레드를 가지고, 최대 40개의 작업을 대기시킬 수 있음
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            20,  // 코어 스레드 수
            40, // 최대 스레드 수
            60L, TimeUnit.SECONDS, // 유휴 시간
            new LinkedBlockingQueue<>(80)
        );

        for (int i = 0; i < threadCount; i++) {
            executor.submit(new RunnableTask(latch));
        }

        latch.await();
    }
}

