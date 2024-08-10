package faang.school.godbless.task.lru.cache;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

@RequiredArgsConstructor
public class LruCacheManager {
    private final static int CACHE_SIZE = 5;

    private final DataStructure dataStructure;
    private final LinkedHashMap<Integer, Data> cache;

    public void addNewDataIntoDataStructure(Data data) {
        dataValidOrNullPointerExceptionThrow(data);
        dataStructure.addData(data);
    }

    public Data findDataById(int id) {
        Data data;
        if (cache.containsKey(id)) {
            data = cache.remove(id);
            data.setTimeStamp(LocalDateTime.now());
        } else {
            data = dataStructure.findDataById(id);
            data.setTimeStamp(LocalDateTime.now());
            if (cache.size() >= CACHE_SIZE) {
                Data oldData = cache.entrySet().iterator().next().getValue();
                cache.remove(oldData.getId());
            }
        }
        cache.put(data.getId(), data);
        return data;
    }

    public void printAllDataInCache() {
        if (cache.isEmpty()) {
            System.out.println("Кэш пуст");
        }
        System.out.println("All data in cache:");
        cache.values().forEach(data -> {
            System.out.println(data);
        });
    }

    private void dataValidOrNullPointerExceptionThrow(Data data) {
        if (data == null) {
            throw new NullPointerException("Данные не могут быть null");
        }
    }
}
