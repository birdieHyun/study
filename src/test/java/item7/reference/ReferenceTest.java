package item7.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import org.example.item7.reference.BigObject;
import org.example.item7.reference.BigObjectPhantom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReferenceTest {

    @Test
    @DisplayName("Weak Reference")
    void test() throws InterruptedException {
        Object strongReference = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(strongReference);
        strongReference = null;

        System.gc();
        Thread.sleep(2000L);

        System.out.println(weakReference.get());
    }

    @Test
    @DisplayName("Soft Reference")
    void test2() throws InterruptedException {
        // 더이상 strong 하게 reference 하는게 없고, soft reference level로 레퍼런스 하고 있으면 이 오브젝트는 gc의 대상이 된다.
        // 단 메모리가 필요한 상황에서만!
        Object strongReference = new Object();
        SoftReference<Object> softReference = new SoftReference<>(strongReference);
        strongReference = null;

        int rows = 11_392;
        int cols = 11_392;
        int[][] largeArray = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                largeArray[i][j] = i + j;
            }
        }

        System.gc();
        Thread.sleep(2000L);

        // 메모리가 충분하기 때문에 없어지지 않는다.
        System.out.println(strongReference);
        System.out.println(softReference.get());
    }

    @Test
    @DisplayName("Weak Reference")
    void test5() throws InterruptedException {

        WeakReference<Object> weakReference = new WeakReference<>(new Object());

        System.gc();
        Thread.sleep(2000L);

        System.out.println(weakReference.get());
    }

    @Test
    @DisplayName("soft reference")
    void test3() throws InterruptedException {

        SoftReference<Object> soft = new SoftReference<>(new Object());

        int rows = 11_392;
        int cols = 11_392;
        int[][] largeArray = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                largeArray[i][j] = i + j;
            }
        }

        System.gc();
        Thread.sleep(2000L);

        System.out.println(soft.get());
    }

    @Test
    @DisplayName("Phantom Reference")
    void test4() throws InterruptedException {

        BigObject strongReference = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();

        BigObjectPhantom phantomReference = new BigObjectPhantom(strongReference, rq);
        strongReference = null;

        Reference<? extends BigObject> poll = rq.poll();
        if (poll == null) {
            System.out.println("phantom reference 가 비어있습니다.");
        }

        // isEnqueued()는 deprecated
//        System.out.println(phantomReference.isEnqueued());

        System.gc();
        Thread.sleep(2000L);

        Reference<? extends BigObject> reference = rq.poll();
        BigObjectPhantom bigObjectReference = (BigObjectPhantom) reference;
        bigObjectReference.cleanUp();
        reference.clear(); // 메모리 누수 방지

        // 최종적으로 rq가 비어있게 된다.
        System.out.println(rq.poll());
    }
}
