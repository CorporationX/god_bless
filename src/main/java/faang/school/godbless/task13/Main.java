package faang.school.godbless.task13;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    public static final int CACHE_SIZE = 3;
    public static Map<Integer, Data> dataMap = new HashMap<>();
    public static Map<Integer, Data> cache = new HashMap<>();

    public static void main(String[] args) {
        addData(new Data(1, "Data 1"));
        addData(new Data(2, "Data 2"));
        addData(new Data(3, "Data 3"));
        addData(new Data(4, "Data 4"));
        addData(new Data(5, "Data 5"));
        addData(new Data(6, "Data 6"));

        Data data1 = getData(1);
        Data data2 = getData(2);
        Data data3 = getData(3);
        Data data4 = getData(4);
        Data data5 = getData(5);
        Data data6 = getData(6);

        System.out.println("Retrieved data: " + data4.getValue());

        addData(new Data(7, "Data 7"));

        printCacheInfo();
    }

    public static void addData(Data data) {
        dataMap.put(data.getId(), data);
    }

    public static Data getData(int id) {
        if (cache.containsKey(id)) {
            cache.get(id).setTimestamp(LocalDate.now());
            return cache.get(id);
        } else if (dataMap.containsKey(id)) {
            clearCache();
            cache.put(id, dataMap.get(id));
            cache.get(id).setTimestamp(LocalDate.now());
            return cache.get(id);
        } else throw new NoSuchElementException("Data with id " + id + " not found");

    }

    public static void clearCache() {
        if (cache.size() > CACHE_SIZE) {
            System.out.println("Начинается очистка кэша");
            LocalDate minDate = LocalDate.MAX;
            int minDateId = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
                if (entry.getValue().getTimestamp().isBefore(minDate)) {
                    minDate = entry.getValue().getTimestamp();
                    minDateId = entry.getKey();
                }
            }
            if (minDateId != Integer.MIN_VALUE) {
                cache.remove(minDateId);
                System.out.println("Очистка завершена успешно");
            }
        }
    }

    public static void printCacheInfo() {
        System.out.println("Cache Info:");
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            Data data = entry.getValue();
            System.out.println("ID: " + data.getId() + ", Value: " + data.getValue() + ", Timestamp: " + data.getTimestamp());
        }
    }
}
