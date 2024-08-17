package faang.school.godbless.javahashmap.lrucache;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class Cache {

    private static final int CACHE_SIZE = 4;

    private final Map<Integer, Data> idToDataMap = new HashMap<>();

    // пришлось сделать Pair<Integer, Long> вместо просто Long, чтобы решить проблему когда timestamp одинаковый у разных data
    private final Map<Pair<Integer, Long>, Data> timeToDataMap = new LinkedHashMap<>();

    public void add(Data data) {
        if (idToDataMap.size() == CACHE_SIZE) {
            Map.Entry<Pair<Integer, Long>, Data> lru = timeToDataMap.entrySet().iterator().next();
            timeToDataMap.remove(lru.getKey());
            idToDataMap.remove(lru.getValue().getId());
        }

        int id = data.getId();

        if (idToDataMap.containsKey(id)) {
            timeToDataMap.remove(new Pair<>(id, data.getTimestamp()));
        }

        data.updateTimestamp();

        timeToDataMap.put(new Pair<>(id, data.getTimestamp()), data);
        idToDataMap.put(id, data);
    }

    public Data get(int id) {

        Data data = idToDataMap.get(id);

        if (data == null) {
            data = new Data(id, "some new value");
        }

        add(data);

        return data;
    }
}
