package faang.school.godbless.LRUCache;

import faang.school.godbless.LRUCache.classes.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    private static Map<Integer, Data> cache = new HashMap<>();
    private static List<Data> structure = new ArrayList<>();
    private static Data oldestData;
    private static final int CACHE_SIZE = 2;

    public static void main(String[] args) {
        Main.addData(new Data(0, "Data 1"));
        Main.addData(new Data(1, "Data 2"));
        Main.addData(new Data(2, "Data 3"));
        Main.addData(new Data(3, "Data 4"));
        Main.addData(new Data(4, "Data 5"));
        Main.addData(new Data(5, "Data 6"));
        Main.addData(new Data(6, "Data 7"));
        Main.addData(new Data(7, "Data 8"));
        Main.addData(new Data(8, "Data 9"));
        Main.addData(new Data(9, "Data 10"));
        Main.addData(new Data(10, "Data 11"));

        Data data = getData(0);
        Data data1 = getData(1);
        Data data2 = getData(0);

        showCacheInfo();

        Data data3 = getData(10);
        Data data4 = getData(5);
        Data data5 = getData(2);
        Data data6 = getData(6);

        showCacheInfo();
    }

    public static void addData(Data data){
        structure.add(data);
    }

    public static Data getData(int id){
        if (!cache.containsKey(id)){
            addDataInCache(structure.get(id));
        }
        cache.get(id).setTimestamp(Date.from(Instant.now()));
        if (oldestData == null || oldestData.getTimestamp().after(cache.get(id).getTimestamp())){
            oldestData = cache.get(id);
        }
        return cache.get(id);
    }

    private static void addDataInCache(Data data) {
        if (cache.size() == CACHE_SIZE){
            removeOldestData();
        }
        cache.put(data.getId(), data);
    }

    private static void removeOldestData() {
        cache.remove(oldestData.getId());
    }

    public static void showCacheInfo(){
        System.out.println("--------------------------------");
        for (Map.Entry<Integer, Data> entry : cache.entrySet()){
            System.out.println(+ entry.getKey() +
                    ": " + entry.getValue().getValue() +
                    ". Timestamp: " +
                    entry.getValue().getTimestamp());
        }
        System.out.println("--------------------------------");
    }
}
