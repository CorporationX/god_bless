package faang.school.godbless.lru.cache;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataStructure {
    private final int CACHE_SIZE = 4;
    private Map<Integer, Data> dataSrtucture = new HashMap<>();
    private Map<Integer, Data> nodes = new LinkedHashMap<>();
    private Map<Integer, Data> cache = new HashMap<>();

    public void addDataToDataStructure (Data data) {
        dataSrtucture.putIfAbsent(data.getId(), data);
        nodes.put(data.getId(), data);
    }

    public void removeDataFromCache () {
        Data cacheFirstItem = cache.get(cache.keySet().toArray()[0]);
        Timestamp oldestTimeStamp = cacheFirstItem.getTimestamp();
        int oldestDataId = cacheFirstItem.getId();

        for (Data item : cache.values()) {
            if (oldestTimeStamp.after(item.getTimestamp())) {
                oldestTimeStamp = item.getTimestamp();
                oldestDataId = item.getId();
            }
        }

        cache.remove(oldestDataId);
    }

    public void getDataById (int id) {
        Data data;
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        if (cache.size() >= CACHE_SIZE) {
            removeDataFromCache();
        }

        if (cache.containsKey(id)) {
            data = cache.get(id);
        } else {
            data = dataSrtucture.get(id);
            cache.put(data.getId(), data);
        }

        data.setTimestamp(currentTime);
    }

    public void getCacheCurrentState () {
        for (Map.Entry<Integer, Data> item : cache.entrySet()) {
            System.out.println("id " + item.getKey() + ";\n data: " + item.getValue() + ";\n timestamp: " + item.getValue().getTimestamp());
        }
    }
}
