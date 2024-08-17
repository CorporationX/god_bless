package faang.school.godbless.task.hashmap.lru.cache;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class LruCacheManager {
    private final static int CACHE_SIZE = 5;

    private final DataStructure dataStructure;
    private final LinkedHashMap<Long, Data> cache = new LinkedHashMap<>(CACHE_SIZE) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Long, Data> eldest) {
            return cache.size() > CACHE_SIZE;
        }
    };

    public void addNewDataIntoDataStructure(@NonNull Data data) {
        dataStructure.addData(data);
    }

    public Data findDataById(Long id) {
        Data data;
        if (cache.containsKey(id)) {
            data = cache.remove(id);
            data.setTimeStamp(LocalDateTime.now());
        } else {
            try {
                data = dataStructure.findDataById(id);
            } catch (NoSuchElementException exception) {
                throw new NoSuchElementException(exception.getMessage());
            }
            data.setTimeStamp(LocalDateTime.now());
        }
        cache.put(data.getId(), data);
        return data;
    }

    public void printAllDataInCache() {
        if (cache.isEmpty()) {
            System.out.println("Кэш пуст");
        }
        System.out.println("Все данные в кеш:");
        cache.values().forEach(data -> {
            System.out.println(data);
        });
    }
}
