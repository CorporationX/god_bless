package faang.school.godbless.LRUCache;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class Main {

    private static int LAST_ID = 1;
    private static final int CACHE_SIZE = 4;
    private static final Map<Integer, Data> CACHE = new HashMap<>();

    public static void main(String[] args) {
        addDataToCache(new Data(LAST_ID, 4, Calendar.getInstance())); // первый id

        addDataToCache(new Data(LAST_ID, 3, Calendar.getInstance()));

        Data tempData = new Data(LAST_ID, 2, Calendar.getInstance());
        tempData.getTimestamp().set(Calendar.DAY_OF_MONTH, 2);
        addDataToCache(tempData);

        tempData = new Data(LAST_ID, 1, Calendar.getInstance());
        tempData.getTimestamp().set(Calendar.DAY_OF_MONTH, 1);
        addDataToCache(tempData);

        addDataToCache(new Data(LAST_ID, 8, Calendar.getInstance()));

        printCache();
        System.out.println();

        getDataById(9);

        printCache();

        System.out.println(getDataById(1).getValue()); // 4
    }

    private static void addDataToCache(Data data) {
        if (CACHE.size() < CACHE_SIZE) {
            CACHE.put(LAST_ID++, data);
        } else {
            Data oldestData = new Data(-1, 5, Calendar.getInstance());

            for (Map.Entry<Integer, Data> entry : CACHE.entrySet()) {
                if (entry.getValue().getTimestamp().before(oldestData.getTimestamp())) {
                    oldestData = entry.getValue();
                }
            }
            CACHE.remove(oldestData.getId());
            CACHE.put(LAST_ID++, data);
        }
    }


    private static Data getDataById(int id) {
        if (CACHE.containsKey(id)) {
            CACHE.get(id).setTimestamp(Calendar.getInstance());
            return CACHE.get(id);
        }

        Data newData = DataStructure.getData(LAST_ID);

        addDataToCache(newData);

        return CACHE.get(LAST_ID);
    }

    private static void printCache() {
        for (Map.Entry<Integer, Data> entry : CACHE.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getId() + " " + entry.getValue().getTimestamp().getTime());
        }
    }
}
