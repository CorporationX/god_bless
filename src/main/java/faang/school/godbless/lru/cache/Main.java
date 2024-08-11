package faang.school.godbless.lru.cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    private static final int CACHE_SIZE = 3;

    public static final Map<Integer, Data> idDataCache = new HashMap<>();
    private static final Map<Integer, Data> idDataDB = new HashMap<>();
    private static final PriorityQueue<Data> queue = new PriorityQueue<>(Comparator.comparing(Data::getTimestamp));

    public static void add(Data data) {
        idDataDB.put(data.getId(), data);
    }

    public static Data get(int id) {
        Data data = idDataCache.get(id);
        if (data != null) {
            data.updateTimestamp();
            idDataCache.put(id, data);
        } else {
            data = idDataDB.get(id);
            data.updateTimestamp();

            if (idDataCache.size() == CACHE_SIZE) {
                Data oldest = queue.poll();
                idDataCache.remove(oldest.getId());
            }

            idDataCache.put(id, data);
            queue.add(data);
        }
        return data;
    }

    private void printCache() {
        idDataCache.values().forEach(System.out::println);
    }
}
