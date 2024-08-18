package faang.school.godbless.BJS2_20366;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static final int CACHE_SIZE = 3;
    private static Map<Integer, Data> dataBase = new HashMap<>();
    private static Map<Integer, Data> lruCache = new LinkedHashMap<>(CACHE_SIZE,0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            return size() > CACHE_SIZE;
        }
    };

    public static void main(String[] args) {
        Data data1 = new Data(1, "London weather", LocalDateTime.now());
        Data data2 = new Data(2, "Angola weather", LocalDateTime.now());
        Data data3 = new Data(3, "France weather", LocalDateTime.now());
        Data data4 = new Data(4, "Italy weather", LocalDateTime.now());
        addDataToDataBase(data1);
        addDataToDataBase(data2);
        addDataToDataBase(data3);
        addDataToDataBase(data4);
        System.out.println("Result of searching:");
        System.out.println(getData(data2.getId()));
        getData(data1.getId());
        System.out.println("Cache content:");
        printCacheContent();
        getData(data2.getId());
        getData(data3.getId());
        System.out.println("Cache content:");
        printCacheContent();
        getData(data4.getId());
        System.out.println("Cache content:");
        printCacheContent();
    }

    public static void addDataToDataBase(Data data) {
        dataBase.putIfAbsent(data.getId(), data);
    }

    public static Data getData(int id) {
        Data data = lruCache.get(id);
        if (data == null) {
            return addDataToCache(id);
        } else {
            data.setTimestamp(LocalDateTime.now());
        }
        return data;
    }

    public static Data addDataToCache(int id) {
        if (dataBase.containsKey(id)) {
            Data data = dataBase.get(id);
            lruCache.put(id, data);
            data.setTimestamp(LocalDateTime.now());
            return data;
        }
        return null;
    }

    public static void printCacheContent() {
        for (var data : lruCache.entrySet()) {
            System.out.println("ID: " + data.getKey());
            System.out.println(data.getValue());
        }
    }
}
