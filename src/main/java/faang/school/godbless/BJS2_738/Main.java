package faang.school.godbless.BJS2_738;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final int CACHE_SIZE = 4;
    public static Map<Integer, Data> cache = new HashMap<>();

    public static void main(String[] args) {
        Data data1 = new Data("Sample Data 1");
        Data data2 = new Data("Sample Data 2");
        Data data3 = new Data("Sample Data 3");

        add(data1);
        add(data2);
        add(data3);

        System.out.println("Current Cache:");
        showCache();

        int idToRetrieve = data2.getId();
        Data retrievedData = getDataById(idToRetrieve);

        System.out.println("Cache after retrieval:");
        showCache();

        add(new Data("Sample Data 4"));
        add(new Data("Sample Data 5"));

        showCache();
    }

    public static void add(Data data) {
        if (cache.size() >= CACHE_SIZE) {
            removeOldestData();
        }
        data.updateTimestamp();
        cache.put(data.getId(), data);
        System.out.println("Added to cache: " + data);
    }

    public static Data getDataById(int id) {
        Data dataFromCache = cache.get(id);

        if (dataFromCache != null) {
            dataFromCache.updateTimestamp();
            System.out.println("From cache: " + dataFromCache);
            return dataFromCache;
        }

        Data dataFromStructure = fetchDataById(id);

        cache.put(id, dataFromStructure);
        dataFromStructure.updateTimestamp();

        System.out.println("From structure: " + dataFromStructure);
        return dataFromStructure;
    }

    public static void removeOldestData() {
        if (!cache.isEmpty()) {
            int minId = Collections.min(
                    cache.values(),
                    Comparator.comparing(Data::getTimestamp)
            ).getId();
            Data removedData = cache.remove(minId);
            System.out.println("Removed oldest data from cache: " + removedData);
        }
    }

    public static void showCache() {
        cache.forEach((id, data) -> System.out.println(data));
    }

    private static Data fetchDataById(int id) {
        return new Data("Data for id = " + id);
    }
}
