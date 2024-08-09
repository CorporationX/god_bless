package faang.school.godbless.lru_cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    static Map<Integer, Data> cache = new HashMap<>();
    static LinkedList<Data> lru = new LinkedList<>();
    private static final int CACHE_SIZE = 10;

    public static void main(String[] args) {
        Data firstData = new Data(1, "Hello");
        Data secondData = new Data(2, "Hello");
        lru.add(firstData);
        System.out.println(lru);

        System.out.println(addData(secondData));
        System.out.println(lru);

        System.out.println(getData(1));
        System.out.println(lru);

        printAllCache();
    }

    public static Data addData(Data data) {
        if (lru.size() == CACHE_SIZE) {
            lru.removeFirst();
        }
        if (lru.contains(data)) {
            return lru.get(lru.indexOf(data));
        }
        lru.add(data);
        return data;
    }

    public static Data getData(int id) {
        if (cache.containsKey(id)) {
            cache.get(id).setTimestamp(new java.util.Date().getTime() / 1000);
            return cache.get(id);
        } else {
            for (Data data : lru) {
                if (data.getId() == id) {
                    data.setTimestamp(new java.util.Date().getTime() / 1000);
                    cache.put(id, data);
                    return data;
                }
            }
        }
        return null;
    }

    public static void printAllCache() {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
