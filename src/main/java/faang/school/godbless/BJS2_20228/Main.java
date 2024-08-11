package faang.school.godbless.BJS2_20228;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class Main {
    private static final int CACHE_SIZE = 3;
    private static int currentCacheSize = 0;
    private static Map<Integer, Data> storage = new HashMap<>();
    private static Map<Integer, Data> cache = new HashMap<>();
    private static SortedMap<Data, Integer> idIndexesByTimestamp = new TreeMap<>();

    private static void addDataToStorage(Data data) {
        storage.put(data.getId(), data);
    }

    private static Data requestData(int id) {
        if (cache.containsKey(id)) {
            Data dataFromCache = cache.get(id);
            idIndexesByTimestamp.remove(dataFromCache);
            dataFromCache.updateTimestamp();
            idIndexesByTimestamp.put(dataFromCache, dataFromCache.getId());
            return dataFromCache;
        } else if (storage.containsKey(id)) {
            Data dataFromStorage = storage.get(id);
            dataFromStorage.updateTimestamp();
            if (currentCacheSize < CACHE_SIZE) {
                cache.put(dataFromStorage.getId(), dataFromStorage);
                idIndexesByTimestamp.put(dataFromStorage, dataFromStorage.getId());
                currentCacheSize++;
            } else if (currentCacheSize == CACHE_SIZE) {
                Data oldestDataFromCache = idIndexesByTimestamp.firstKey();
                int oldestIdFromCache = idIndexesByTimestamp.remove(oldestDataFromCache);
                cache.remove(oldestIdFromCache);
                cache.put(dataFromStorage.getId(), dataFromStorage);
                idIndexesByTimestamp.put(dataFromStorage, dataFromStorage.getId());
            }
            return dataFromStorage;
        } else {
            throw new IllegalArgumentException("This id does not exist");
        }
    }

    private static void viewCache() {
        System.out.println("id\t\t" + "value\t\t" + "timestamp");
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            int id = entry.getKey();
            String value = entry.getValue().getValue();
            String timestamp = entry.getValue().getTimestamp().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
            System.out.println(id + "\t\t" + value + "\t\t" + timestamp);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SortedMap<Data, Integer> ddd = new TreeMap<>();
        Data one = new Data("lolo");
        Thread.sleep(1000);
        Data two = new Data("keks");
        Data three = new Data("ohio");
        Data four = new Data("salam");
        addDataToStorage(one);
        addDataToStorage(two);
        addDataToStorage(three);
        addDataToStorage(four);
        requestData(1);
        Thread.sleep(1000);
        requestData(2);
        Thread.sleep(1000);
        viewCache();
        System.out.println();
        requestData(3);
        Thread.sleep(1000);
        requestData(4);
        viewCache();
    }
}

