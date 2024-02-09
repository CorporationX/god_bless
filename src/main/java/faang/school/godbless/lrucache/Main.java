package faang.school.godbless.lrucache;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    private static final int CACHE_SIZE = 10;
    private static final Map<Long, Data> DATA_CACHE = new HashMap<>();
    private static final List<Data> DATA = new ArrayList<>();

    public static void main(String[] args) {
        Data data1 = new Data(1, "Value 1", System.currentTimeMillis());
        Data data2 = new Data(2, "Value 2", System.currentTimeMillis());
        Data data3 = new Data(3, "Value 3", System.currentTimeMillis());
        Data data4 = new Data(4, "Value 4", System.currentTimeMillis());
        Data data5 = new Data(5, "Value 5", System.currentTimeMillis());
        Data data6 = new Data(6, "Value 6", System.currentTimeMillis());
        Data data7 = new Data(7, "Value 7", System.currentTimeMillis());
        Data data8 = new Data(8, "Value 8", System.currentTimeMillis());
        Data data9 = new Data(9, "Value 9", System.currentTimeMillis());
        Data data10 = new Data(10, "Value 10", System.currentTimeMillis());
        Data data11 = new Data(11, "Value 11", System.currentTimeMillis());

        add(data1);
        add(data2);
        add(data3);
        add(data4);
        add(data5);
        add(data6);
        add(data7);
        add(data8);
        add(data9);
        add(data10);
        add(data11);

        System.out.println("Cache State After Adding Data:");
        printCacheState();

        get(1L);
        get(2L);
        get(3L);
        get(4L);
        get(5L);
        get(6L);
        get(7L);
        get(8L);
        get(9L);
        get(10L);
        get(11L);
        get(1L);

        System.out.println("Cache State After Retrieving Data:");
        printCacheState();
    }

    public static void add(Data data) {
        DATA.add(data);
    }

    public static Data get(Long id) {
        Data data = DATA_CACHE.get(id);
        if (data != null) {
            data.setTimestamp(System.currentTimeMillis());
            return data;
        }
        optimizeCache();
        data = DATA.stream()
                .filter(value -> value.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Data does not exist"));
        data.setTimestamp(System.currentTimeMillis());
        DATA_CACHE.put(data.getId(), data);
        return data;
    }

    public static void printCacheState() {
        DATA_CACHE.values().forEach(System.out::println);
    }

    private static void optimizeCache() {
        if (DATA_CACHE.size() == CACHE_SIZE) {
            DATA_CACHE.remove(DATA_CACHE.values().stream()
                    .min(Comparator.comparingLong(Data::getTimestamp))
                    .get().getId());
        }
    }
}
