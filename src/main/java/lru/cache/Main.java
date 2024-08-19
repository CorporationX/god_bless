package lru.cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private final static Map<Integer, Data> dataBase = new HashMap<>();
    private final static int CACHE_SIZE = 3;

    private final static Map<Integer, Data> cache = new LinkedHashMap<>(CACHE_SIZE) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            if (cache.size() > CACHE_SIZE) {
                System.out.println("Удален старый элемент");
                return true;
            }
            return false;
        }
    };

    public static void main(String[] args) {

        Data data1 = new Data(1, "Car");
        Data data2 = new Data(2, "Apple");
        Data data3 = new Data(3, "Dog");
        Data data4 = new Data(4, "Cat");

        dataBase.put(data1.getId(), data1);
        dataBase.put(data2.getId(), data2);
        dataBase.put(data3.getId(), data3);
        dataBase.put(data4.getId(), data4);

        System.out.println(getData(1));
        System.out.println("---");
        System.out.println(getData(2));
        System.out.println("---");
        System.out.println(getData(3));
        System.out.println("---");
        System.out.println(getData(1));
        System.out.println("---");
        System.out.println(getData(4));
        System.out.println("---");
        printCache(cache);


    }

    public static Data getData(int id) {
        if (cache.containsKey(id)) {
            Data data = cache.remove(id);
            data.setTimestamp(LocalDateTime.now());
            cache.put(id, data);
            System.out.println("Данные полученны кэша.");
            return data;
        } else {
            if (dataBase.containsKey(id)) {
                Data data = dataBase.get(id);
                data.setTimestamp(LocalDateTime.now());
                System.out.println("Данные полученны из базы и добавлены в кэш.");
                cache.put(id, data);
                System.out.println("Данные полученны из кэша.");
                return data;
            } else {
                throw new IllegalArgumentException("Данных нет");
            }
        }
    }

    public static void printCache(Map<Integer, Data> cache) {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
