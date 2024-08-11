package faang.school.godbless.lru_cache;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    private static final int CACHE_SIZE = 3;
    private final HashMap<Integer, Data> cache = new HashMap<>();

    public static void main(String[] args) {
        Main cacheManager = new Main();

        cacheManager.addData(1, "1");
        cacheManager.addData(2, "2");
        cacheManager.addData(3, "3");

        cacheManager.printAllCache();

        cacheManager.getData(1);

        cacheManager.printAllCache();

        cacheManager.addData(4, "4");

        cacheManager.printAllCache();
    }

    public void addData(int id, String value) {
        if (cache.size() >= CACHE_SIZE) {
            removeOldData();
        }
        Data data = new Data(id, value);
        cache.put(id, data);
    }

    public Data getData(int id) {
        Data data = cache.get(id);
        if (data != null) {
            data.setTimestamp(LocalDateTime.now().atZone(ZoneId.of("UTC")).toInstant().getEpochSecond());
            return data;
        }
        return data;
    }

    private void removeOldData() {
        Optional<Map.Entry<Integer, Data>> oldestEntry = cache.entrySet().stream()
                .min(Map.Entry.comparingByValue((date_first, date_second) ->
                        Math.toIntExact(date_first.getTimestamp() - date_second.getTimestamp())));
        oldestEntry.ifPresent(entry -> cache.remove(entry.getKey()));
    }

    public void printAllCache() {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry);
        }
    }
}
