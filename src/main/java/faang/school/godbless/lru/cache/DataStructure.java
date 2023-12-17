package faang.school.godbless.lru.cache;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataStructure {
    private final int CACHE_SIZE = 4;
    private Map<Integer, Data> dataSrtucture = new HashMap<>();
    private Map<Integer, Data> cache = new HashMap<>();

    public Map<Integer, Data> addData(Data data) {
        dataSrtucture.putIfAbsent(data.getId(), data);

        return dataSrtucture;
    }

    public void getDataById(int id) {
        Data data;
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        if (cache.size() > CACHE_SIZE) {
            removeDataFromCache();
        }

        if (cache.containsKey(id)) {
            data = cache.get(id);
        } else {
            data = dataSrtucture.get(id);
            cache.putIfAbsent(data.getId(), data);
        }

        data.setTimestamp(currentTime);
    }

    public void removeDataFromCache() {
        Timestamp oldestTimeStamp = cache.get(cache.keySet().toArray()[0]).getTimestamp();
        int oldestDataId = cache.get(cache.keySet().toArray()[0]).getId();

        for (Data item : cache.values()) {
            if (oldestTimeStamp.compareTo(item.getTimestamp()) > 0) {
                oldestDataId = item.getId();
            }
        }

        cache.remove(oldestDataId);
    }

    public void getCacheCurrentState() {
        for (Map.Entry<Integer, Data> item : cache.entrySet()) {
            System.out.println("id " + item.getKey() + "\n; data: " + item.getValue() + "\n; timestamp: " + item.getValue().getTimestamp());
        }
    }
}
