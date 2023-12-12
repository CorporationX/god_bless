package faang.school.godbless.java_hashmap.lru_cache;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Integer, Data> fakeDB = new HashMap<>();
    private static final LRUCache<Integer, Data> lruCache = new LRUCache<>(3);


    static {
        fakeDB.put(1, new Data(1, "Дорогой дневник, мне не подобрать слов чтобы описать боль и унижение которые я испытал сегодня", LocalDateTime.now()));
        fakeDB.put(2, new Data(2, "Data 2", LocalDateTime.now()));
        fakeDB.put(3, new Data(3, "Data 3", LocalDateTime.now()));
        fakeDB.put(4, new Data(4, "Data 4", LocalDateTime.now()));
        fakeDB.put(5, new Data(5, "Data 5", LocalDateTime.now()));
        fakeDB.put(6, new Data(6, "Data 6", LocalDateTime.now()));
        fakeDB.put(7, new Data(7, "Data 7", LocalDateTime.now()));
        fakeDB.put(8, new Data(8, "Data 8", LocalDateTime.now()));
        fakeDB.put(9, new Data(9, "Data 9", LocalDateTime.now()));
        fakeDB.put(10, new Data(10, "Data 10", LocalDateTime.now()));
        fakeDB.put(11, new Data(11, "Data 11", LocalDateTime.now()));
        fakeDB.put(12, new Data(12, "Data 12", LocalDateTime.now()));
        fakeDB.put(13, new Data(13, "Data 13", LocalDateTime.now()));
        fakeDB.put(14, new Data(14, "Data 14", LocalDateTime.now()));
        fakeDB.put(15, new Data(15, "Data 15", LocalDateTime.now()));
    }

    public static void main(String[] args) {
        getDataById(1);
        getDataById(2);
        getDataById(3);
        getDataById(4);
        getDataById(5);
        getDataById(6);
        printCacheState();
    }


    public static void add(Data data) {
        if (data == null) throw new IllegalArgumentException("args is null");
        fakeDB.put(data.getId(), data);
    }

    public static Data getDataById(int id) {
        if (id < 0) throw new IllegalArgumentException("the id cannot be less than 0");
        Data data = lruCache.get(id);
        if (data == null) {
            data = fakeDB.get(id);
            lruCache.put(id, data);
        }
        data.setTimestamp(LocalDateTime.now());
        return data;
    }

    public static void printCacheState() {
        lruCache.printCacheState();
    }


}
