package faang.school.godbless.BJS2_4137;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final int CACHE_SIZE = 3;
    private static final Map<Integer, Data> CACHE = new HashMap<>();

    public static void main(String[] args) {
        addDataToCache(new Data(1, "Значение 1"));
        addDataToCache(new Data(2, "Значение 2"));
        addDataToCache(new Data(3, "Значение 3"));

        displayCache();

        System.out.println(getDataFromCache(2));
        addDataToCache(new Data(4, "Значение 4"));
        displayCache();
    }

    public static void addDataToCache(Data data) {
        if (CACHE.size() == CACHE_SIZE) {
            removeEldest();
        }

        CACHE.put(data.id, data);
        data.updateTimestamp();
    }

    public static Data getDataFromCache(int id) {
        Data data = CACHE.get(id);

        if (data == null) {
            addDataToCache(new Data(id, ""));
            return CACHE.get(id);
        }

        data.updateTimestamp();
        return data;
    }

    private static void removeEldest() {
        Integer oldDataId = Objects.requireNonNull(CACHE.entrySet()
                .stream()
                .min(Comparator.comparing(d -> d.getValue().getTimestamp()))
                .orElse(null)).getKey();

        CACHE.remove(oldDataId);
    }

    public static void displayCache() {
        CACHE.values().forEach(System.out::println);
    }
}