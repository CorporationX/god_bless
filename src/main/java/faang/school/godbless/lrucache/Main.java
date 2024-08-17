package faang.school.godbless.lrucache;

import java.util.*;

public class Main {

    private static final int CACHE_SIZE = 3;
    private static final Map<Integer, Data> dataMap = new HashMap<>();
    private static final Map<Integer, Data> cache = new LinkedHashMap<>();

    private static void addData(int id, String value) {
        dataMap.put(id, new Data(id, value));
    }

    private static Data getData(int id) {
        Data data;

        if (cache.containsKey(id)) {
            data = cache.get(id);
        } else {
            data = dataMap.get(id);
        }

        if (data != null) {
            data.updateTimestamp();
            addCache(data);
        }

        return data;
    }

    private static void addCache(Data data) {
        if (cache.size() >= CACHE_SIZE) {
            shrinkCache();
        }

        cache.put(data.getId(), data);
    }

    private static void shrinkCache() {
        cache.remove(cache.keySet().iterator().next());
    }

    private static void printCacheStatus() {
        System.out.println("cache status:");

        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            Data data = entry.getValue();
            System.out.printf("  id: %d; value: %s; timestamp: %s%n", data.getId(), data.getValue(), data.getTimestamp());
        }
    }



    public static void main(String[] args) {
        addData(0, "value_0");
        addData(1, "value_1");
        addData(2, "value_2");
        addData(3, "value_3");
        addData(4, "value_4");

        getData(0);
        getData(1);
        getData(2);
        getData(3);
        getData(1);
        getData(0);
        getData(4);
        getData(2);
        getData(2);
        getData(0);
        getData(2);
        getData(3);
        getData(4);
        getData(1);

        printCacheStatus();
    }
}
