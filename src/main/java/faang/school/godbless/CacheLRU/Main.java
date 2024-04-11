package faang.school.godbless.CacheLRU;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final int CACHE_SIZE = 4;
    private static final Map<Integer, Data> CACHE = new HashMap<>();

    private static final Map<Integer, Data> DATA_STORAGE = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();

        main.addData(1, "Value 1");
        main.addData(2, "Value 2");
        main.addData(3, "Value 3");

        System.out.println(main.getData(1).getValue());
        System.out.println(main.getData(2).getValue());

        main.addData(4, "Value 4");
        main.addData(5, "Value 5");
        main.addData(6, "Value 6");

        main.printCacheState();
    }

    public void addData(int id, String value) {

        Data newData = new Data(id, value, System.currentTimeMillis());
        if (CACHE.size() >= CACHE_SIZE) {
            removeOldest();
        }
        CACHE.put(id, newData);
        DATA_STORAGE.put(id, newData);
    }

    public Data getData(int id) {

        if (CACHE.containsKey(id)) {
            Data data = CACHE.get(id);
            data.setTimestamp(System.currentTimeMillis());
            return data;
        } else if (DATA_STORAGE.containsKey(id)) {
            Data data = DATA_STORAGE.get(id);
            if (CACHE.size() >= CACHE_SIZE) {
                removeOldest();
            }

            CACHE.put(id, data);
            data.setTimestamp(System.currentTimeMillis());
            return data;
        } else {
            return null;
        }
    }

    private void removeOldest() {

        long oldestTimestamp = Long.MAX_VALUE;
        Integer keyToRemove = null;
        for (Map.Entry<Integer, Data> entry : CACHE.entrySet()) {
            if (entry.getValue().getTimestamp() < oldestTimestamp) {
                oldestTimestamp = entry.getValue().getTimestamp();
                keyToRemove = entry.getKey();
            }
        }
        CACHE.remove(keyToRemove);
    }

    public void printCacheState() {

        System.out.println("Cache state:");
        for (Map.Entry<Integer, Data> entry : CACHE.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Value: " + entry.getValue().getValue() +
                    ", Last Acess Time: " + entry.getValue().getTimestamp());
        }
    }
}
