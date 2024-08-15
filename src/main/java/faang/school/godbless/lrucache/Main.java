package faang.school.godbless.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static final int CACHE_SIZE = 4;

    private static Map<Integer, Data> cache = new LinkedHashMap<>(CACHE_SIZE, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Data> eldest) {
            return size() > CACHE_SIZE;
        }
    };

    public static void main(String[] args) {

        addData(new Data(1, "Value1"));
        addData(new Data(2, "Value2"));
        addData(new Data(3, "Value3"));
        addData(new Data(6, "Value6"));
        addData(new Data(7, "Value7"));

        System.out.println("Cache state as of now:");
        printCacheState();

        System.out.println("\nAccessing data with ID 1:");
        getDataById(1);
        printCacheState();

        System.out.println("\nAdding new data with ID 4:");
        addData(new Data(4, "Value4"));
        printCacheState();

        System.out.println("\nAccessing data with ID 2:");
        getDataById(2);
        printCacheState();

        System.out.println("\nAdding new data with ID 5:");
        addData(new Data(5, "Value5"));
        printCacheState();

        System.out.println("\nAccessing data with ID 3:");
        getDataById(3);
        printCacheState();

        System.out.println("\nAccessing data with ID 5:");
        getDataById(5);
        printCacheState();
    }

    public static void addData(Data data) {
        DataService.addData(data);
        cache.put(data.getId(), data);
    }

    public static void getDataById(int id) {
        Data data = cache.get(id);
        if (data == null) {
            data = DataService.getDataById(id);
            if (data != null) {
                data.updateTimestamp();
                cache.put(id, data);
            }
        } else {
            data.updateTimestamp();
        }
    }

    public static void printCacheState() {
        for (Map.Entry<Integer, Data> entry : cache.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
