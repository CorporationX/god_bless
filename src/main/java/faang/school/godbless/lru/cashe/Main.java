package faang.school.godbless.lru.cashe;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<Integer, Data> storage = new HashMap<>();
    public static Map<Integer, Data> cashe = new HashMap<>();
    private static final int CACHE_SIZE = 3;

    public static void main(String[] args) {
        Data data1 = new Data("Море");
        Data data2 = new Data("Океан");
        Data data3 = new Data("Дождь");
        Data data4 = new Data("Молнии");
        Data data5 = new Data("Ночь");
        addData(data1);
        addData(data2);
        addData(data3);
        addData(data4);
        addData(data5);
        printCache();
        System.out.println();
        getData(1);
        printCache();
        System.out.println();
        getData(2);
        printCache();
        System.out.println();
        getData(3);
        printCache();
        System.out.println();
        getData(4);
        printCache();
        System.out.println();
        getData(3);
        printCache();
    }

    public static void addData(Data data) {
        storage.putIfAbsent(data.getId(), data);
    }

    public static void getData(Integer id) {
        if (cashe.containsKey(id)) {
            cashe.get(id);
            updateTheTame(id);
            removeOverflow();
        }
        putInDataCache(id);
        updateTheTame(id);
        removeOverflow();
        storage.get(id);
    }

    public static void putInDataCache(Integer id) {
        Data dataFromStorage = storage.get(id);
        cashe.putIfAbsent(dataFromStorage.getId(), dataFromStorage);
    }

    public static void removeOverflow() {
        int bufferId = 0;
        LocalDateTime buffer = LocalDateTime.now();
        if (cashe.size() > CACHE_SIZE) {
            for (Data data : cashe.values()) {
                if (buffer.isAfter(data.getTimetemp())) {
                    buffer = data.getTimetemp();
                    bufferId = data.getId();
                }
            }
            cashe.remove(bufferId);
        }
    }

    public static void printCache() {
        for (Map.Entry<Integer, Data> data : cashe.entrySet()) {
            System.out.println(data);
        }
    }

    public static void updateTheTame(Integer id) {
        cashe.get(id).setTimetemp(LocalDateTime.now());
    }
}

