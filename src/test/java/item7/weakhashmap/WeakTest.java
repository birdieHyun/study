package item7.weakhashmap;

import org.example.item7.weakhashmap.CacheKey;
import org.example.item7.weakhashmap.PostRepository;
import org.junit.jupiter.api.Test;

class WeakTest {

    @Test
    void test() throws InterruptedException {

        PostRepository repository = new PostRepository();
        Integer p1 = 1;
        repository.getPostByIdCache(p1);

        System.out.println("캐시 사이즈 : " + repository.getCacheSize());
        System.out.println("GC 실행");
        System.gc();
        Thread.sleep(3000L);

        System.out.println("캐시 사이즈 : " + repository.getCacheSize());
    }

    @Test
    void test2() throws InterruptedException {

        PostRepository repository = new PostRepository();
        CacheKey cacheKey = new CacheKey(1);
        repository.getPostByIdNotCache(cacheKey);

        System.out.println("캐시 사이즈 : " + repository.getCacheSize());
        System.out.println("GC 실행");
        System.gc();
        Thread.sleep(3000L);

        System.out.println("캐시 사이즈 : " + repository.getCacheSize());
    }

    @Test
    void test3() throws InterruptedException {

        PostRepository repository = new PostRepository();
        CacheKey cacheKey = new CacheKey(1);
        repository.getPostByIdNotCache(cacheKey);

        System.out.println("캐시 사이즈 : " + repository.getCacheSize());
        System.out.println("GC 실행");
        System.gc();
        Thread.sleep(3000L);

        System.out.println("캐시 사이즈 : " + repository.getCacheSize());

        System.out.println("cacheKey null 처리 후");
        cacheKey = null;
        System.gc();
        Thread.sleep(3000L);

        System.out.println("캐시 사이즈 : " + repository.getCacheSize());
    }
}
