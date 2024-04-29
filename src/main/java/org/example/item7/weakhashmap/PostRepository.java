package org.example.item7.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;
import lombok.Getter;

@Getter
public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository() {
//        this.cache = new HashMap<>();
        // weakhashmap을 사용하면 cache key가 참조되지 않을 경우 메모리에서 해제된다.
        this.cache = new WeakHashMap<>();
    }

    public Post getPostByIdCache(Integer id) {

        CacheKey cacheKey = new CacheKey(id);

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }else{
            Post post = new Post();
            cache.put(cacheKey, post);
            return post;
        }
    }

    public Post getPostByIdNotCache(CacheKey cacheKey) {

        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }else{
            Post post = new Post();
            cache.put(cacheKey, post);
            return post;
        }
    }

    public int getCacheSize() {
        return cache.size();
    }
}
