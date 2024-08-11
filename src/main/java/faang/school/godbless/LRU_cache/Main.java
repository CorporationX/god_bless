package faang.school.godbless.LRU_cache;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int CACHE_SIZE = 3;

    public static Map<Integer, Data> dataMap = new HashMap<>();

    public static Map<Integer, Data> dataCacheMap = new HashMap<>(CACHE_SIZE);

    public static void main(String[] args) throws InterruptedException {
        Data data = new Data(1, "value", Instant.now());
        Thread.sleep(1000);
        Data data2 = new Data(2, "value2", Instant.now());
        Thread.sleep(1000);
        Data data3 = new Data(3, "value3", Instant.now());
        Thread.sleep(1000);
        Data data4 = new Data(4, "value4", Instant.now());

        dataCacheMap.put(data2.getId(), data2);
        dataCacheMap.put(data3.getId(), data3);
        dataCacheMap.put(data4.getId(), data4);

        addDataToMap(data.getId(), data);
        addDataToMap(data2.getId(), data2);
        addDataToMap(data3.getId(), data3);
        addDataToMap(data4.getId(), data4);

        getData(data);

        printDataFromCache();
    }

    public static void addDataToMap(Integer dataId, Data data) {
        dataMap.put(dataId, data);
    }

    public static Data getData(Data data) {
        Data existedData;

        if (dataCacheMap.containsKey(data.getId())) {
            existedData = dataCacheMap.get(data.getId());
        } else {
            existedData = dataMap.get(data.getId());

            addDataToCache(existedData);
        }

        existedData.setTimestamp(Instant.now());

        return existedData;
    }

    public static void addDataToCache(Data data) {
        if (dataCacheMap.size() == 3) {
            List<Data> dataList = new ArrayList<>(dataCacheMap.values());
            Collections.sort(dataList);

            dataCacheMap.remove(dataList.get(dataList.size() - 1).getId());
        }

        dataCacheMap.put(data.getId(), data);
    }

    public static void printDataFromCache() {
        dataCacheMap.entrySet().forEach(System.out::println);
    }
}
