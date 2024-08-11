package lru_cache;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Main {
    private static final int CACHE_SIZE = 3;
    private final static Map<Integer, Data> dataMap = new HashMap<>();
    private final static Map<Integer, Data> cache = new LinkedHashMap<>(CACHE_SIZE) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            return cache.size() > CACHE_SIZE;
        }
    };

    public static void main(String[] args) {
        Data data1 = new Data(1, 1);
        Data data2 = new Data(2, 1);
        Data data3 = new Data(3, 1);
        Data data4 = new Data(4, 1);

        addToDataMap(data1);
        addToDataMap(data2);
        addToDataMap(data3);
        addToDataMap(data4);

        getDataById(1); // получаем из основной, кладем в кэш
        getDataById(1); // берем из кэша
        getDataById(2);
        getDataById(3);
        getDataById(4); // кэш заполнен, удаляется Data с id 1
        getDataById(1); // опять получаем из основной

        printAllData();
    }

    public static Data getDataById(int dataId) {
        if (cache.containsKey(dataId)) {
            return getFromCache(dataId);
        } else {
            if (dataMap.containsKey(dataId)) {
                Data data = getFromDataMap(dataId);
                addToCache(data);
                return data;
            }
        }
        throw new NoSuchElementException("Нет данных с таким идентификатором");
    }

    public static void addToDataMap(Data data) {
        if (!dataMap.containsKey(data.getId())) {
            data.setTimestamp(LocalTime.now());
            dataMap.put(data.getId(), data);
        }
    }

    public static void printAllData() {
        dataMap.forEach((key, value) -> System.out.printf("ID %s: %s\n", key, value));
    }

    private static void addToCache(Data data) {
        data.setTimestamp(LocalTime.now());
        cache.put(data.getId(), data);
    }

    private static Data getFromDataMap(int dataId) {
        System.out.println("Получено из DataMap");
        Data data = dataMap.get(dataId);
        data.setTimestamp(LocalTime.now());
        return data;
    }

    private static Data getFromCache(int dataId) {
        System.out.println("Получено из кэша");
        Data data = cache.get(dataId);
        data.setTimestamp(LocalTime.now());
        return data;
    }
}
