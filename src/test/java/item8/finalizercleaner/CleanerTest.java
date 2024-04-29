package item8.finalizercleaner;

import org.example.item8.cleaner.BigObject;
import org.example.item8.cleaner.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

class CleanerTest {

    @Test
    @DisplayName("cleaner test")
    void teenager() throws InterruptedException {
        new Room(99); // 생성 후 바로 소멸되기 때문에 gc의 대상이 된다.
        System.gc();

        Thread.sleep(3000L);
    }

    @Test
    @DisplayName("cleaner try-with-resources")
    void adult() {

        try (Room room = new Room(7)) {}
    }

    @Test
    void test() throws InterruptedException {
        Cleaner cleaner = Cleaner.create();

        List<Object> resourceToCleanUp = new ArrayList<>();
        BigObject bigObject = new BigObject(resourceToCleanUp);
        cleaner.register(bigObject, new BigObject.ResourceCleaner(resourceToCleanUp));

        // gc가 일어나면서 cleaner가 동작한다.
        bigObject = null;
        System.gc();
        Thread.sleep(3000L);
    }
}
