package lru;

import java.util.Map;
import java.util.HashMap;

public class Main {
    private static final int CACHE_SIZE = 3;
    private static Map<Integer, Data> dataCache = new HashMap<>();

    public static void main(String[] args) {
        addDataToCache(new Data(1, "Value1"));
        addDataToCache(new Data(2, "Value2"));
        addDataToCache(new Data(3, "Value3"));

        printCacheState();

        getDataFromCache(1);
        getDataFromCache(2);
        getDataFromCache(10);

        printCacheState();

        addDataToCache(new Data(4, "Value4"));
        addDataToCache(new Data(5, "Value5"));

        printCacheState();
    }

    private static void addDataToCache(Data data) {
        if (dataCache.size() >= CACHE_SIZE) {
            deleteOldestData();
        }
        dataCache.put(data.getId(), data);
    }

    private static Data getDataFromCache(int id) {
        if (dataCache.containsKey(id)) {
            Data data = dataCache.get(id);
            data.updateTimestamp();
            return data;
        } else {
            System.out.println("Data with ID " + id + " not found in cache. Loading from storage...");
            Data newData = new Data(id, "NewValue" + id);
            addDataToCache(newData);
            return newData;
        }
    }

    private static void deleteOldestData() {
        long oldestTimestamp = Long.MAX_VALUE;
        int oldestId = 0;

        for (Map.Entry<Integer, Data> entry : dataCache.entrySet()) {
            if (entry.getValue().getTimestamp() < oldestTimestamp) {
                oldestTimestamp = entry.getValue().getTimestamp();
                oldestId = entry.getKey();
            }
        }

        System.out.println("Deleting the oldest data with ID " + oldestId);
        dataCache.remove(oldestId);
    }

    private static void printCacheState() {
        System.out.println("Cache state:");
        for (Map.Entry<Integer, Data> entry : dataCache.entrySet()) {
            Data data = entry.getValue();
            System.out.println("ID: " + data.getId() + ", Value: " + data.getValue() + ", Timestamp: " + data.getTimestamp());
        }
        System.out.println();
    }
}