package BJS2_20319;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    private static final int CACHE_SIZE = 2;
    private static final Map<Integer, Data> dataStructure = new HashMap<>();
    private static final Map<Integer, Data> cache = new LinkedHashMap<>() {
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            return size() > CACHE_SIZE;
        }
    };

    public static void main(String[] args) {
        Data data1 = new Data(1, 2, LocalDateTime.now());
        Data data2 = new Data(2, 3, LocalDateTime.now());
        Data data3 = new Data(3, 4, LocalDateTime.now());

        dataStructure.put(data3.getId(), data3);

        //Adding data to the data structure and cache
        addData(data1);
        addData(data2);

        //Getting data by id
        System.out.println(getDataById(3));

        //Printing all data info
        printAllData();
    }

    public static void addData(Data data) {
        try {
            dataStructure.putIfAbsent(data.getId(), data);
            cache.computeIfAbsent(data.getId(), key -> data).setTimestamp(LocalDateTime.now());
        } catch (NullPointerException e) {
            System.out.println("Data can't be null!");
        }
    }

    public static Optional<Data> getDataById(int id) {
        if (isNullData(id)) {
            System.out.println("There is no data with such id!");
            return Optional.empty();
        } else {
            cache.computeIfAbsent(id, key -> dataStructure.get(id)).setTimestamp(LocalDateTime.now());
            return Optional.ofNullable(cache.get(id));
        }
    }

    public static boolean isNullData(int id) {
        return dataStructure.get(id) == null;
    }

    public static void printAllData() {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry.getValue().getId() + " " + entry.getValue().getValue() + " " + entry.getValue().getTimestamp());
        }
    }
}
