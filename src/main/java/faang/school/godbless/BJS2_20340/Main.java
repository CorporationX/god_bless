package faang.school.godbless.BJS2_20340;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static int CACHE_SIZE = 4;
    static LRUCache lruCache = new LRUCache(CACHE_SIZE);
    private final static Map<Integer, Data> storage = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        addData(new Data(0, "data1", LocalDateTime.now()));
        addData(new Data(1, "data2", LocalDateTime.now()));
        addData(new Data(2, "data3", LocalDateTime.now()));
        addData(new Data(3, "data4", LocalDateTime.now()));
        addData(new Data(4, "data5", LocalDateTime.now()));
        getData(2);
        getData(1);
        getData(0);
        getData(3);
        lruCache.printLRUCache();
        System.out.println("========");
        Thread.sleep(2000);
        getData(3);
        lruCache.printLRUCache();
        System.out.println("========");
        getData(4);
        lruCache.printLRUCache();
    }

    public static void addData(Data data) {
        storage.putIfAbsent(data.getId(), data);
    }

    public static Data getData(int id) {
        Data data;
        if (lruCache.get(id) != null) {
            data = lruCache.get(id);
            data.setTimestamp(LocalDateTime.now());
        } else {
            data = storage.get(id);
            if (data != null) {
                data.setTimestamp(LocalDateTime.now());
                lruCache.put(id, data);
            }
        }
        return data;
    }
}
