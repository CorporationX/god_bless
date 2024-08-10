package faang.school.godbless.BJS2_20336;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class LruCacheService {

    private static final long CACHE_SIZE = 3;

    private Map<Integer, Data> dataMap = new HashMap<>();
    private LinkedHashMap<Integer, Data> cache = new LinkedHashMap<>();

    public void put(int id, Data data) {
        cache(data);
        dataMap.put(id, data);
    }

    public Optional<Data> get(int id) {
        Data data = dataMap.get(id);
        if (data == null) {
            return Optional.empty();
        }

        data.setTimestamp(System.currentTimeMillis());
        cache(data);
        return Optional.of(data);
    }

    private void cache(Data data) {
        if (cache.size() == CACHE_SIZE) {
            if (!cache.containsKey(data.getId())) {
                Integer oldDataKey = cache.keySet().toArray(new Integer[0])[0];
                cache.remove(oldDataKey);
            } else {
                cache.remove(data.getId());
            }
        }
        cache.put(data.getId(), data);
    }

    public void printCache() {
        cache.forEach((id, data) ->
                System.out.printf("%d = %s, %d%n", id, data.getValue(), data.getTimestamp()));
    }
}
