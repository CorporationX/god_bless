package faang.school.godbless.LRU_cache;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomDataStorage {

    private static final Map<Integer, Data> CACHE = new HashMap<>();
    private static final Map<Integer, Data> ALL_DATA = new HashMap<>();
    private static final List<Data> queue = new LinkedList<>();
    private static final int CACHE_SIZE = 3;

    public void addData(Data data) {

        if (!ALL_DATA.containsKey(data.getId())) {
            ALL_DATA.put(data.getId(), data);
        }

        if (CACHE.size() == CACHE_SIZE) {
            removeOldDataFromCache();
        }

        CACHE.put(data.getId(), data);
    }

    public Data getDataById(int id) {
        Data data = CACHE.getOrDefault(id, null);

        if (data == null) {
            data = ALL_DATA.get(id);
            removeOldDataFromCache();
            CACHE.put(data.getId(), data);
        }

        data.setTimestamp(LocalDateTime.now());

        return data;
    }

    public void printInfoAboutCache() {
        CACHE.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }

    private void removeOldDataFromCache() {
        Data data = CACHE.values().stream()
                .min(Comparator.comparing(Data::getTimestamp))
                .get();

        CACHE.remove(data.getId());
    }
}
