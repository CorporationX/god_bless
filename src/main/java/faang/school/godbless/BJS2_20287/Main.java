package faang.school.godbless.BJS2_20287;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    List<Data> DB = new ArrayList<>();
    final int CACHE_SIZE = 27;
    Map<Integer, Data> cache = new LinkedHashMap<>();

    public void addDataToDB(Data data) {
        DB.add(data);
    }

    public Data getDataByID(Integer id) {
        if(cache.containsKey(id)) {
            cache.get(id).setTimestamp(LocalDateTime.now());
            return cache.get(id);
        }

        for(var data : DB) {
            if(data.getId() == id) {
                data.setTimestamp(LocalDateTime.now());
                if(cache.size() > CACHE_SIZE) {
                    Integer firstKey = cache.keySet().iterator().next();
                    cache.remove(firstKey);
                }
                cache.put(data.getId(), data);
                return data;
            }
        }

        throw new IllegalArgumentException("Data with ID " + id + " not found");
    }

    // if we use simple HashMap(Not the LinkedHashMap), we can use this function
    private void removeOldestEntry() {
        Integer oldestKey = null;
        LocalDateTime oldestTimestamp = LocalDateTime.now();

        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            if (entry.getValue().getTimestamp().isBefore(oldestTimestamp)) {
                oldestTimestamp = entry.getValue().getTimestamp();
                oldestKey = entry.getKey();
            }
        }

        if (oldestKey != null) {
            cache.remove(oldestKey);
        }
    }

    public void printAllCache() {
        for(var entry : cache.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
