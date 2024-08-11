package lru.cache;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Getter
public class Main {
    public static int CACHE_SIZE = 5;
    private final Map<Integer, Data> cache = new LinkedHashMap<>(CACHE_SIZE) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            return cache.size() > CACHE_SIZE;
        }
    };
    private final Map<Integer, Data> dataBase = new HashMap<>();

    public static void main(String[] args) {
        Main cacheStructure = new Main();
        Data data1 = new Data("very importand data1", LocalDateTime.now());
        Data data2 = new Data("very importand data2", LocalDateTime.now());
        Data data3 = new Data("very importand data3", LocalDateTime.now());
        Data data4 = new Data("very importand data4", LocalDateTime.now());
        Data data5 = new Data("very importand data5", LocalDateTime.now());
        Data data6 = new Data("very importand data6", LocalDateTime.now());
        cacheStructure.addDateToBase(data1);
        cacheStructure.addDateToBase(data2);
        cacheStructure.addDateToBase(data3);
        cacheStructure.addDateToBase(data4);
        cacheStructure.addDateToBase(data5);
        cacheStructure.addDateToBase(data6);
        cacheStructure.printCache();
        cacheStructure.getData(1);
        cacheStructure.getData(2);
        cacheStructure.getData(3);
        cacheStructure.getData(4);
        cacheStructure.getData(5);
        cacheStructure.printCache();
        cacheStructure.getData(3);
        cacheStructure.getData(5);
        cacheStructure.printCache();
        cacheStructure.getData(6);
        cacheStructure.printCache();
        try {
            cacheStructure.getData(10);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        cacheStructure.printCache();

    }

    public void addDateToBase(@NonNull Data data) {
        if (!dataBase.containsKey(data.getId())) {
            dataBase.put(data.getId(), data);
        } else {
            System.out.println("\nThis data is already in database");
        }
    }

    public Data getData(int id) {
        if (cache.containsKey(id)) {
            return getDataFromCache(id);
        } else {
            if (dataBase.containsKey(id)) {
               return getDataFromBase(id);
            } else {
                System.out.println("\nThere is no data with this id in database");
                throw new NoSuchElementException("\nThere is no data with this id in database");
            }
        }
    }

    private Data getDataFromCache(int id) {
        var data = cache.get(id);
        cache.remove(id);
        putDataInCache(data);

        return data;
    }

    private Data getDataFromBase(int id) {
        var data =  dataBase.get(id);
        putDataInCache(data);

        return data;
    }

    private void putDataInCache(@NonNull Data data) {
        data.setTimestamp(LocalDateTime.now());
        cache.put(data.getId(), data);
    }

    private void printCache() {
        System.out.println();
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(
                    entry.getKey() + " : " +
                    entry.getValue().getValue() + " : " +
                    entry.getValue().getTimestamp());
        }
    }
}
