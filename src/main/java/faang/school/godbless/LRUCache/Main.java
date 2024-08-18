package faang.school.godbless.LRUCache;

import java.util.Date;
import java.util.HashMap;

public class Main {
    private static final int CACHE_SIZE = 5;

    private static HashMap<Integer, Data> cache = new HashMap<>();

    private static Data findDataByTimestamp(Date timestamp) {
        for (Data data : cache.values()) {
            if (data.getTimestamp().compareTo(timestamp) == 0) {
                return data;
            }
        }
        return null;
    }

    private static Data findOldestData() {
        Date timestampOfOldestData = new Date();
        for (Data data : cache.values()) {
            if (data.getTimestamp().before(timestampOfOldestData)) {
                timestampOfOldestData = data.getTimestamp();
            }
        }
        return findDataByTimestamp(timestampOfOldestData);
    }

    public static void deleteOldestData() {
        Data dataToDelete = findOldestData();
        if (dataToDelete != null) {
            cache.remove(dataToDelete.getId());
        }
    }

    public static void addData(Data data) {
        if (cache.size() > CACHE_SIZE) {
            deleteOldestData();
        }
        data.setTimestamp(new Date());
        cache.put(data.getId(), data);
    }

    public static Data getData(int id) {
        if (cache.containsKey(id)){
            cache.get(id).setTimestamp(new Date());
            return cache.get(id);
        } else {
            System.out.println("There is no data with id " + id + "in cache");
            return null;
        }
    }

    public static void checkCache() {
        for (Data data : cache.values()) {
            System.out.println(data);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        addData(new Data(1, "Some data 1"));
        Thread.sleep(1000);
        addData(new Data(2, "Some data 2"));
        Thread.sleep(1000);
        addData(new Data(3, "Some data 3"));
        Thread.sleep(1000);
        addData(new Data(4, "Some data 4"));
        Thread.sleep(1000);
        addData(new Data(5, "Some data 5"));
        Thread.sleep(1000);

        checkCache();

        addData(new Data(6, "Some data 6"));
        Thread.sleep(1000);
        addData(new Data(7, "Some data 7"));
        Thread.sleep(1000);
        addData(new Data(8, "Some data 8"));
        Thread.sleep(1000);

        System.out.println();
        System.out.println(getData(6) + "\n");

        checkCache();
    }
}
