package faang.school.godbless.BJS2_20317;

import java.util.*;

public class Main {
    private static Map<Integer, Data> dataStructure = new HashMap<>();
    private static Map<Integer, Data> cacheMap = new HashMap<>();
    private static final int CACHE_SIZE = 10;

    public static void main(String[] args) {
        Data data = new Data("data1");
        
        addData(data);

        System.out.println(getData(data.getId()));
        
        printCachedData();

        System.out.println(getData(data.getId()));
    }

    private static void addData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("Data can not be null");
        }
        if (dataStructure.containsKey(data.getId())) {
            throw new RuntimeException("Key " + data.getId() + " already exists");
        }

        dataStructure.put(data.getId(), data);
    }

    private static void addCacheData(Data data) {
        if (data == null) {
            throw new IllegalArgumentException("Data can not be null");
        }
        if (cacheMap.containsKey(data.getId())) {
            throw new RuntimeException("Key " + data.getId() + " already exists");
        }
        if (cacheMap.size() >= CACHE_SIZE) {
            List<Data> cachedData = new ArrayList<>();
            for (Map.Entry<Integer, Data> entry : cacheMap.entrySet()) {
                cachedData.add(entry.getValue());
            }
            cachedData.sort(Comparator.comparing(Data::getTimestamp));
            cacheMap.remove(cachedData.get(0).getId());
        }
        cacheMap.put(data.getId(), data);
    }

    private static Data getData(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id can not be negative");
        }

        if (cacheMap.containsKey(id)) {
            cacheMap.get(id).updateTimestamp();
            return cacheMap.get(id);
        }
        if (dataStructure.containsKey(id)) {
            Data data = dataStructure.get(id);
            addCacheData(data);
            data.updateTimestamp();
            return data;
        }
        System.out.println("No data found for id " + id);
        return null;
    }

    private static void printCachedData() {
        for (Map.Entry<Integer, Data> entry : cacheMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getTimestamp());
        }
    }
}
