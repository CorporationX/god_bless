package BJS2_20085;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    private static final int CACHE_SIZE = 2;
    private static final Map<Integer, Data> dataMap = new HashMap<>();
    private static final Map<Integer, Data> cache = new HashMap<>();
    private static final PriorityQueue<Data> cacheQueue = new PriorityQueue<>(Comparator.comparing(Data::getTimestamp));

    public static void main(String[] args) {
        addDataToMap(1, "Value1");
        addDataToMap(2, "Value2");
        addDataToMap(3, "Value3");
        addDataToMap(4, "Value4");

        getData(1);
        getData(2);
        getData(3);
        getData(1);
        getData(4);
        getData(2);
        getData(2);
        getData(2);
        getData(3);
        getData(1);

        displayCache();
    }

    private static void addDataToMap(int id, String value) {
        dataMap.put(id, new Data(id, value));
    }

    private static void getData(int id) {
        if (cache.containsKey(id)) {
            Data data = cache.get(id);
            data.updateTimestamp();
            updateCachePriorityQueue(data);
        } else {
            Data data = dataMap.get(id);
            if (data != null) {
                data.updateTimestamp();
                addToCache(data);
            }
        }
    }

    private static void addToCache(Data data) {
        if (cache.size() >= CACHE_SIZE) {
            removeOldestCacheItem();
        }
        cache.put(data.getId(), data);
        cacheQueue.add(data);
    }

    private static void removeOldestCacheItem() {
        Data oldestData = cacheQueue.poll();
        if (oldestData != null) {
            cache.remove(oldestData.getId());
        }
    }

    private static void updateCachePriorityQueue(Data data) {
        cacheQueue.remove(data);
        cacheQueue.add(data);
    }

    private static void displayCache() {
        System.out.println("Состояние кэша:");
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            Data data = entry.getValue();
            System.out.printf("ID: %d, Value: %s, Timestamp: %s%n", data.getId(), data.getValue(), data.getTimestamp());
        }
    }
}
