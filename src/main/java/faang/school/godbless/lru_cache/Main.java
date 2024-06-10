package faang.school.godbless.lru_cache;

import lombok.ToString;

import java.util.*;


public class Main {
//    db or some other type of storage
    List<Data> storage = new ArrayList<>();
    LinkedHashMap<Integer, Data> cache;

    public Main(int cache_size) {
        cache = new LinkedHashMap<>(cache_size, 1, true){
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size() > cache_size;
            }
        };
    }

    public Data get(int key) {
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
//        If data not found in cache find in storage and put in cache
        for (Data data : storage) {
            if (data.id == key) {
                cache.put(key, data);
                return data;
            }
        }
        return null;
    }

//    Since not stated otherwise put doesnt update cache
    public void put(Data data) {
        storage.add(data);
    }

    public int[] getCacheStatus() {
        System.out.println("===================");
        System.out.println(cache);
        return cache.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
}
