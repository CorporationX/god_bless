package faang.school.godbless.BJS2_8950;

import java.time.LocalDateTime;
import java.util.*;

public class Cache {
    private Map<Integer, Data> cache;
    private DataBase dataBase;

    public Cache(int cacheSize, DataBase dataBase) {
        this.dataBase = dataBase;
        this.cache = new LinkedHashMap<>(cacheSize, 1, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    public void addData(Data data) {
        if (cache.containsKey(data.getId())) {
            System.out.println("Такой ключ уже существует");
            return;
        }
        data.setTimestamp(LocalDateTime.now());
        cache.put(data.getId(), data);
    }

    public Data getData(int id) {
        if (!cache.containsKey(id)) {
            Optional.of(dataBase.getData(id)).ifPresentOrElse(this::addData, () -> {
                System.out.println("Элемента" + id + "нет в базе");
                throw new NullPointerException();
            });
        }
        cache.get(id).setTimestamp(LocalDateTime.now());
        return cache.get(id);
    }

    public void printStatus() {
        cache.entrySet().forEach(System.out::println);
    }
}
