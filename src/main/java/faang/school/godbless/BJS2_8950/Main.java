package faang.school.godbless.BJS2_8950;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private final static int CACHE_SIZE = 3;

    static Map<Integer, Data> dataBase = new HashMap<>();
    static Map<Integer, Data> cache = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        addData(new Data(1, "value1", LocalDateTime.now()));
        addData(new Data(2, "value2", LocalDateTime.now()));
        addData(new Data(3, "value3", LocalDateTime.now()));
        addData(new Data(4, "value4", LocalDateTime.now()));
        addDataToCache(dataBase.get(1));
        Thread.sleep(100);
        addDataToCache(dataBase.get(2));
        Thread.sleep(100);
        addDataToCache(dataBase.get(3));
        printCacheStatus();
        Thread.sleep(100);
        System.out.println();
        System.out.println(getData(4));
        System.out.println();
        printCacheStatus();
    }

    public static void addDataToCache(Data data) {
        if (cache.size() >= CACHE_SIZE) {
            int oldestId = cache.entrySet().stream()
                    .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().getTimestamp()))
                    .entrySet().stream()
                    .min(Map.Entry.comparingByValue()).get().getKey();
            cache.remove(oldestId);
        }
        data.setTimestamp(LocalDateTime.now());
        cache.put(data.getId(), data);
    }

    public static void addData(Data data) {
        dataBase.put(data.getId(), data);
    }

    public static Data getData(int id) {
        if (!cache.containsKey(id)) {
            addDataToCache(dataBase.get(id));
        }
        cache.get(id).setTimestamp(LocalDateTime.now());
        return cache.get(id);
    }

    public static void printCacheStatus() {
        cache.entrySet().forEach(System.out::println);
    }
}
