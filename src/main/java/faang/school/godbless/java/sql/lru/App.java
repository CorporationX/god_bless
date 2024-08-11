package faang.school.godbless.java.sql.lru;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        Map<Integer, Data> cachedData = new HashMap<>();

        try {
            Data data1 = new Data(1, "Dog");
            addOrUpdateDataInCache(cachedData, data1);
            TimeUnit.SECONDS.sleep(Constants.SLEEP_TIME);

            Data data2 = new Data(2, "Cat");
            addOrUpdateDataInCache(cachedData, data2);
            TimeUnit.SECONDS.sleep(Constants.SLEEP_TIME);

            Data data3 = new Data(3, "Monkey");
            addOrUpdateDataInCache(cachedData, data3);
            TimeUnit.SECONDS.sleep(Constants.SLEEP_TIME);

            Data data4 = new Data(4, "Tennis");
            addOrUpdateDataInCache(cachedData, data4);
            TimeUnit.SECONDS.sleep(Constants.SLEEP_TIME);

            Data data5 = new Data(2, "Cat");
            addOrUpdateDataInCache(cachedData, data5);
            TimeUnit.SECONDS.sleep(Constants.SLEEP_TIME);

            Data data6 = new Data(5, "Water");
            addOrUpdateDataInCache(cachedData, data6);

            Data data7 = new Data(6, "Surf");
            addOrUpdateDataInCache(cachedData, data7);

        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        showCacheState(cachedData);

    }

    public static void addOrUpdateDataInCache(Map<Integer, Data> cachedData, Data data) {

        if (cachedData.size() >= Constants.CACHE_SIZE) {
            Data oldestData = null;
            for (Map.Entry<Integer, Data> entry: cachedData.entrySet()) {
                if (oldestData == null || entry.getValue().getTimestamp().isBefore(oldestData.getTimestamp())) {
                    oldestData = entry.getValue();
                }
            }
            cachedData.remove(oldestData.getId());
        }
        cachedData.computeIfAbsent(data.getId(), k -> data).setTimestamp(LocalDateTime.now());
    }

    public static void showCacheState(Map<Integer, Data> cachedData) {
        System.out.println("Cache contains the following values:");
        List<Data> dataList = new ArrayList<>();
        for (Map.Entry<Integer, Data> entry: cachedData.entrySet()) {
            dataList.add(entry.getValue());
        }
        dataList.sort(Comparator.comparing(Data::getTimestamp));

        for (Data data: dataList) {
            System.out.println(data);
        }
    }
}
