package faang.school.godbless.BJS2_738;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static final int CACHE_SIZE = 4;
    public static final Map<Integer, Data> cache = new LinkedHashMap<>(CACHE_SIZE, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            return size() > CACHE_SIZE;
        }
    };

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
        System.out.println("From structure: " + dataFromStructure);
        return dataFromStructure;
    }

    public static void showCache() {
        cache.forEach((id, data) -> System.out.println(data));
    }

    private static Data fetchDataById(int id) {
        return new Data("Data for id = " + id);
    }
}