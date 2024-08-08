package faang.school.godbless.beksultan2005;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Map<Integer, Data> cacheData = new HashMap<>();
    private static LinkedList<Integer> listID = new LinkedList<>();
    private static List<Data> dataList = new ArrayList<>(); //структуру данных
    private static final int CACHE_SIZE = 12;

    private static void addData(Data data) {
        dataList.add(data);
    }

    private static Data getDataById(int id) {
        if (cacheData.containsKey(id)) {
            cacheData.get(id).setCurrentDate(Instant.now());
            return cacheData.get(id);
        } else {
            Data data = dataList.get(id);
            data.setCurrentDate(Instant.now());
            if (listID.size() >= CACHE_SIZE) {
                cacheData.remove(listID.getFirst());
                listID.removeFirst();
            } else {
                listID.addLast(id);
            }
            cacheData.put(id, data);
            return data;
        }
    }

    public static void getAllCacheData() {
        cacheData.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void getAllData() {
        dataList.forEach((value) -> System.out.println(value));
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 16; i++) {
            addData(new Data(i, "Value " + i, LocalDate.now()));
        }

        for (int i = 1; i <= 15; i++) {
            getDataById(i);
        }

        getAllData();

        getAllCacheData();

    }
}
