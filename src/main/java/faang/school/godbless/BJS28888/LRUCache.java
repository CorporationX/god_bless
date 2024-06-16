package faang.school.godbless.BJS28888;

import lombok.Getter;

import java.time.Instant;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private int cacheSize;
    @Getter
    private Map<Integer, Data> cache;

    public LRUCache(int cacheSize) {
        if (cacheSize <= 0) {
            throw new IllegalArgumentException("CacheSize cannot be less then 1 element!");
        } else {
            this.cacheSize = cacheSize;
            this.cache = new LinkedHashMap<Integer, Data>(cacheSize, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
                    return size() > cacheSize;
                }
            };
        }
    }

    public Data getElement(int id) {
        cache.get(id).setTimeStamp(Instant.now());
        return cache.get(id);
    }

    public Data addElement(Data data) {
        data.setTimeStamp(Instant.now());
        cache.put(data.getId(), data);
        return data;
    }

    public void printCache() {
        System.out.println("\nSTART PRINTING CACHE");
        cache.values().forEach(System.out::println);
        System.out.println("FINISH PRINTING CACHE\n");
    }
}
