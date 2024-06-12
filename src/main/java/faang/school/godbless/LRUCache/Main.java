package faang.school.godbless.LRUCache;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    private static Map<Integer, Data> dataObjectsCash = new HashMap<>();
    private static Map<Integer, Data> dataList = new HashMap<>();

    private static final int CACHE_SIZE = 3;

    public static void main(String[] args) {
        Data data1 = new Data(1, "qd");
        Data data2 = new Data(2, "qd");
        Data data3 = new Data(3, "qd");
        Data data4 = new Data(4, "qd");
        addData(data1);
        addData(data2);
        addData(data3);
        addData(data4);

        getData(1);
        getData(2);
        getData(3);
        getData(4);

        info();

    }

    static void addData(Data data) {
        dataList.put(data.getId(), data);
    }

    static void getData(int dataId) {
        if (dataObjectsCash.containsKey(dataId)) {
            update(dataId);
            dataObjectsCash.get(dataId);
        }
        putDataObjectCash(dataId);
        update(dataId);
        removeCash();
        dataList.get(dataId);
    }

    static void putDataObjectCash(int id) {
        Data data = dataList.get(id);
        dataObjectsCash.put(data.getId(), data);
    }

    static void info() {
        for (Map.Entry<Integer, Data> map : dataObjectsCash.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }
    }

    static void removeCash() {
        LocalDateTime timeNow = LocalDateTime.now();
        int id = 0;
        if (dataObjectsCash.size() > CACHE_SIZE) {
            for (Data data : dataObjectsCash.values()) {
                if (timeNow.isAfter(data.getTimestamp())) {
                    timeNow = data.getTimestamp();
                    id = data.getId();
                }
            }
            dataObjectsCash.remove(id);
        }
    }

    static void update(int id) {
        dataObjectsCash.get(id).setTimestamp(LocalDateTime.now());
    }
}
