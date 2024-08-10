package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final int size;
    private final HashMap<String, Data> cache = new HashMap<>();

    public LRUCache(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Cache size must be greater than 0");
        }
        this.size = size;
    }

    public Data getData(String id) {
        if (id == null || !cache.containsKey(id)) {
            return null;
        }

        Data data = cache.get(id);
        data.updateTimestamp();

        return data;
    }

    public void addData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (cache.size() >= this.size) {
            removeOldestData();
        }

        cache.put(data.getId(), data);
    }

    private void removeOldestData() {
        cache.entrySet().stream()
                .min(Map.Entry.comparingByValue((data1, data2) -> Long.compare(data1.getTimestamp(), data2.getTimestamp())))
                .ifPresent(oldestData -> {
                    cache.remove(oldestData.getKey());
                    System.out.println("Data removed from cache: \n    " + oldestData);
                });
    }

    public void print() {
        System.out.println("Current Cache:");
        cache.forEach((id, data) -> System.out.println("    " + data));
    }
}
