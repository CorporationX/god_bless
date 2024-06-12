package faang.school.godbless.lru.сache;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final int CACHE_SIZE = 5;
    private static Map<Integer, Data> dataStorage = new HashMap<>();

    public static void addDataToStorage(int id, String value) {
        if (id != 0 && value != null) {
            if (dataStorage.size() != CACHE_SIZE) {
                dataStorage.put(id, new Data(id, value, LocalDateTime.now()));
            } else {
                Map.Entry<Integer, Data> minEntry = dataStorage.entrySet().stream()
                        .min(Comparator.comparing(entry -> entry.getValue().getTimestamp()))
                        .orElseThrow(() -> new IllegalStateException("dataStorage is empty"));

                dataStorage.remove(minEntry.getKey());
                dataStorage.put(id, new Data(id, value, LocalDateTime.now()));
            }
        } else {
            System.err.println("Error!");
        }
    }

    public static Data getData(int id) {
        if (dataStorage.containsKey(id)) {
            dataStorage.get(id).setTimestamp(LocalDateTime.now());
            return dataStorage.get(id);
        } else {
            Data newData = dataStructures();
            addDataToStorage(newData.getId(), newData.getValue());
            return dataStorage.get(id);
        }
    }

    private static Data dataStructures() {
        return new Data(6, "Value6", LocalDateTime.now());
    }

    public static void printCache() {
        System.out.println("Current cache state:");
        for (Map.Entry<Integer, Data> entry : dataStorage.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {

        addDataToStorage(1, "Value1");
        addDataToStorage(2, "Value2");
        addDataToStorage(3, "Value3");
        addDataToStorage(4, "Value4");
        addDataToStorage(5, "Value5");

        printCache();

        getData(1);
        getData(2);
        getData(3);
        getData(4);
        getData(5);
        getData(6);

        printCache();
    }
}
