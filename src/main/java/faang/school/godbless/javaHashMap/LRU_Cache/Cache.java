package faang.school.godbless.javaHashMap.LRU_Cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cache {
    private static final int CACHE_SIZE = 10;
    private final Map<Integer, Data> cache;
    private final Main dataService;

    public Cache(Main dataService) {
        this.dataService = dataService;
        cache = new HashMap<>();
    }

    public Data getData(int id) {
        Data data = cache.get(id);

        if (data != null) {
            data.updateTimestamp();
            return data;
        }

        data = dataService.getData(id);
        populateCache(id, data);

        return data;
    }

    private void populateCache(int id, Data data) {
        cache.put(id, data);
        data.updateTimestamp();

        if (cache.size() <= CACHE_SIZE) {
            return;
        }

        Optional<Data> lruData = cache.values().stream().min(Comparator.comparing(Data::getTimestamp));

        cache.remove(lruData.get().getId());
    }

    public void printCache() {
        if (cache.isEmpty()) {
            System.out.println("Cache is empty.");
            return;
        }

        System.out.println("Cache storage:");
        cache.values().forEach(System.out::println);
    }
}
