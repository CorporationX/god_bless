package faang.school.godbless.BJS2_20229;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class DataService {

    private final Map<Integer, Data> data;
    private static final int CACHE_SIZE = 5;
    private final Map<Integer, Data> cache;
    private final Set<Integer> cacheQueue;

    public DataService(Map<Integer, Data> data) {
        this.data = data;
        this.cache = new HashMap<>();
        this.cacheQueue = new LinkedHashSet<>();
    }

    public void addData(Data dataToAdd) {
        if (data.containsKey(dataToAdd.getId())) {
            throw new IllegalArgumentException("Data with id " + dataToAdd.getId() + " already exists");
        }

        data.put(dataToAdd.getId(), dataToAdd);
        addDataToCache(dataToAdd);
    }

    public Data getDataById(int id) {
        Data dataToReturn;
        if (!data.containsKey(id)) {
            throw new IllegalArgumentException("Data with id " + id + " does not exist");
        }

        if (cache.containsKey(id)) {
            dataToReturn = cache.get(id);
            cache.get(id).setTimestamp(LocalDateTime.now());
            cacheQueue.remove(id);
            cacheQueue.add(id);
        } else {
            dataToReturn = data.get(id);
            data.get(id).setTimestamp(LocalDateTime.now());
            addDataToCache(data.get(id));
        }
        return dataToReturn;
    }

    public void addDataToCache(Data dataToAdd) {
        if (cache.size() < CACHE_SIZE) {
            cache.put(dataToAdd.getId(), dataToAdd);
            cacheQueue.add(dataToAdd.getId());
        } else {
            removeData();
            cache.put(dataToAdd.getId(), dataToAdd);
            cacheQueue.add(dataToAdd.getId());
        }
    }

    public void removeData() {
        Iterator<Integer> iterator = cacheQueue.iterator();
        if (iterator.hasNext()) {
            Integer id = iterator.next();
            cacheQueue.remove(id);
            cache.remove(id);
        }
    }

    public void printCache() {
        cache.forEach((id, data) -> System.out.println(id + ": " + data));
    }

}
