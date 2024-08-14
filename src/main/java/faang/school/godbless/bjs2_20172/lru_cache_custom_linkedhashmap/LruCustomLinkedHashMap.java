package faang.school.godbless.bjs2_20172.lru_cache_custom_linkedhashmap;

import faang.school.godbless.bjs2_20172.Data;

import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Comparator.comparing;

public class LruCustomLinkedHashMap {
    private static final int CACHE_SIZE = 3;
    private final Map<Integer, Data> storage = new HashMap<>();
    private final CustomLinkedHashMap<Integer, Data> cache = new CustomLinkedHashMap<>(CACHE_SIZE);

    public void addData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        storage.put(data.getId(), data);
    }

    public Data getData(int id) {
        var dataFromCache = cache.get(id);
        if (dataFromCache == null) {
            var dataFromStorage = storage.get(id);
            if (dataFromStorage == null) {
                return null;
            }
            dataFromStorage.setTimestamp(now());
            cache.put(id, dataFromStorage);
            return dataFromStorage;
        }

        dataFromCache.setTimestamp(now());

        cache.remove(id);
        cache.put(id, dataFromCache);

        return dataFromCache;
    }

    public void printCache() {
        cache.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    private void removeOldestData() {
        cache.values().stream()
                .min(comparing(Data::getTimestamp))
                .ifPresent(data -> cache.remove(data.getId()));
    }

    // for tests
    public Data getDataById(int id) {
        return storage.get(id);
    }

    // for tests
    public void addDataToCache(Data data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        cache.put(data.getId(), data);
    }

    // for tests
    public Map<Integer, Data> getCache() {
        return cache;
    }

    // for tests
    public Map<Integer, Data> getStorage() {
        return storage;
    }
}
